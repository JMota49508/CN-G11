package grpcserverapp;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.WriteChannel;
import com.google.cloud.firestore.*;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.*;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import io.grpc.stub.StreamObserver;
import servicestubs.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class Service extends ServiceGrpc.ServiceImplBase {

    private final static StorageOptions storageOptions = StorageOptions.getDefaultInstance();
    private final static Storage storage = storageOptions.getService();
    private final static String bucketName = "bucket-g11-cn-61d-europe";
    private static Firestore db = null;
    private final static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public Service() {
        try {
            GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
            FirestoreOptions options = FirestoreOptions.newBuilder().setDatabaseId("image-storage")
                    .setCredentials(credentials).build();
            db = options.getService();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void submitFile(InputFile request, StreamObserver<TextMessage> responseObserver) {
        try {
            // get the file content
            byte[] fileContent = request.getFile().toByteArray();
            // get the file content type
            String contentType = request.getContentType();
            // get the file name
            String fileName = request.getFileName();
            // create blob name
            String blobName = UUID.randomUUID().toString();

            String message = "File uploaded with ID: " + bucketName + "-" + blobName;

            TextMessage response = TextMessage.newBuilder().setTxt(message).build();

            uploadFileToBucket(fileContent, contentType, blobName);

            TopicName topicName = TopicName.ofProjectTopicName("CN2324-T1-G11", "image-processor");
            Publisher publisher = Publisher.newBuilder(topicName).build();

            ByteString data = ByteString.copyFromUtf8(message);
            PubsubMessage pubSubMessage = PubsubMessage.newBuilder()
                    .setData(data)
                    .putAttributes("bucketName", bucketName)
                    .putAttributes("blobName", blobName)
                    .putAttributes("fileName", fileName)
                    .build();
            ApiFuture<String> future = publisher.publish(pubSubMessage);
            String msgId = future.get();
            System.out.println("Message published with ID: " + msgId);
            publisher.shutdown();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getImageLabels(TextMessage request, StreamObserver<FileLabels> responseObserver) {
        try {
            DocumentReference docRef = db.collection("image-storage").document(request.getTxt());
            ApiFuture<DocumentSnapshot> future = docRef.get();
            DocumentSnapshot document = future.get();
            File file = document.toObject(File.class);
            FileLabels.Builder labelsBuilder = FileLabels.newBuilder();
            for (String label : file.labels) {
                labelsBuilder.addLabels(label);
            }
            responseObserver.onNext(labelsBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getNamesFromDateAndLabel(DatesAndLabel request, StreamObserver<FileNames> responseObserver) {
        try {
            String initDate = request.getInitDate();
            String finalDate = request.getFinalDate();
            String label = new String(Base64.getDecoder().decode(request.getLabel()), StandardCharsets.UTF_8);
            Query query = db.collection("image-storage")
                    .whereGreaterThan("creationDate", Timestamp.from(formatter.parse(initDate).toInstant()))
                    .whereLessThan("creationDate", Timestamp.from(formatter.parse(finalDate).toInstant()))
                    .whereArrayContains("labels", label);
            ApiFuture<QuerySnapshot> querySnapshot = query.get();
            FileNames.Builder namesBuilder = FileNames.newBuilder();
            for (DocumentSnapshot doc : querySnapshot.get().getDocuments()) {
                namesBuilder.addNames(String.valueOf(doc.get("name")));
            }
            responseObserver.onNext(namesBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void downloadFile(TextMessage request, StreamObserver<DownloadedFile> responseObserver) {
        String id = request.getTxt();
        String blobName = id.split(bucketName + "-")[1];
        BlobId blobId = BlobId.of(bucketName, blobName);
        Blob blob = storage.get(blobId);
        byte[] content = blob.getContent();
        responseObserver.onNext(DownloadedFile.newBuilder().setFile(ByteString.copyFrom(content)).build());
        responseObserver.onCompleted();
    }

    private static void uploadFileToBucket(byte[] fileContent, String contentType, String blobName) throws IOException {
        BlobId blobId = BlobId.of(bucketName, blobName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(contentType).build();
        WriteChannel writer = storage.writer(blobInfo);
        byte[] buffer = new byte[1024];
        InputStream input = new ByteArrayInputStream(fileContent);
        int limit;
        while ((limit = input.read(buffer)) >= 0) {
            writer.write(ByteBuffer.wrap(buffer, 0, limit));
        }
        writer.close();
    }

    public static Date getCurrentDate() throws Exception {
        LocalDate currentDate = LocalDate.now();
        Date currentDateAsDate = java.sql.Date.valueOf(currentDate);
        String strDate = formatter.format(currentDateAsDate);
        return formatter.parse(strDate);
    }
}
