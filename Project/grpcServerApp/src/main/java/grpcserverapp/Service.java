package grpcserverapp;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.api.core.ApiFuture;
import com.google.cloud.WriteChannel;
import com.google.cloud.firestore.*;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.protobuf.ByteString;
import servicestubs.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Service extends ServiceGrpc.ServiceImplBase {

    private final static StorageOptions storageOptions = StorageOptions.getDefaultInstance();
    private final static Storage storage = storageOptions.getService();
    private final static String bucketName = "bucket-g11-cn-61d-europe";
    private static Firestore db = null;
    private final static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public Service(int svcPort) {
        try {
            GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
            FirestoreOptions options = FirestoreOptions.newBuilder().setDatabaseId("image-storage")
                    .setCredentials(credentials).build();
            db = options.getService();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Service is available on port:" + svcPort);
    }

    @Override
    public TextMessage submitFile(InputFile request) {
        try {
            // get the file content
            byte[] fileContent = request.getFile().toByteArray();
            // get the file content type
            String contentType = request.getContentType();
            // get the file name
            String fileName = request.getFileName();
            // create blob name
            String blobName = UUID.randomUUID().toString();

            uploadFiletoBucket(fileContent, contentType, blobName);

            List<String> labels = Labels.detectLabels("gs://" + bucketName + "/" + blobName);
            String blobId = insertDocuments(blobName, fileName, db, labels);
            return TextMessage.newBuilder().setTxt(blobId).build();
        } catch (Exception e) {
            return TextMessage.newBuilder().setTxt("Error: " + e.getMessage()).build();
        }
    }

    @Override
    public FileLabels getImageLabels(TextMessage request) throws Exception {
        DocumentReference docRef = db.collection("image-storage").document(request.getTxt());
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        File file = document.toObject(File.class);
        List<String> labels = Translate.translateLabels(file.labels, "en", "pt");
        FileLabels.Builder labelsBuilder = FileLabels.newBuilder();
        for (String label : labels) {
            labelsBuilder.addLabels(label);
        }
        return labelsBuilder.build();
    }

    @Override
    public FileNames getNamesFromDateAndLabel(DatesAndLabel request) throws Exception {
        String initDate = request.getInitDate();
        String finalDate = request.getFinalDate();
        String label = Translate.translateLine(request.getLabel(), "pt", "en");
        Query query = db.collection("image-storage")
                .whereGreaterThan("creationDate", Timestamp.from(formatter.parse(initDate).toInstant()))
                .whereLessThan("creationDate", Timestamp.from(formatter.parse(finalDate).toInstant()))
                .whereArrayContains("labels", label);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        FileNames.Builder namesBuilder = FileNames.newBuilder();
        for (DocumentSnapshot doc : querySnapshot.get().getDocuments()) {
            namesBuilder.addNames(String.valueOf(doc.get("name")));
        }
        return namesBuilder.build();
    }

    @Override
    public DownloadedFile downloadFile(TextMessage request) {
        String id = request.getTxt();
        BlobId blobId = BlobId.of(bucketName, id.split("-")[1]);
        Blob blob = storage.get(blobId);
        byte[] content = blob.getContent();
        return DownloadedFile.newBuilder().setFile(ByteString.copyFrom(content)).build();
    }

    private static void uploadFiletoBucket(byte[] fileContent, String contentType, String blobName) throws IOException {
        BlobId blobId = BlobId.of(bucketName, blobName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(contentType).build();
        WriteChannel writer = storage.writer(blobInfo);
        byte[] buffer = new byte[1024];
        InputStream input = new ByteArrayInputStream(fileContent);
        int limit;
        while ((limit = input.read(buffer)) >= 0) {
            writer.write(ByteBuffer.wrap(buffer, 0, limit));
        }
    }

    private static String insertDocuments(String blobName, String fileName, Firestore db, List<String> labels) throws Exception {
        CollectionReference colRef = db.collection("image-storage");
        File file = new File();
        file.id = bucketName + "-" + blobName;
        file.name = fileName;
        file.labels = labels;
        file.creationDate = getCurrentDate();
        DocumentReference docRef = colRef.document(file.id);
        docRef.set(file);
        return file.id;
    }

    private static Date getCurrentDate() throws Exception {
        LocalDate currentDate = LocalDate.now();
        Date currentDateAsDate = java.sql.Date.valueOf(currentDate);
        String strDate = formatter.format(currentDateAsDate);
        return formatter.parse(strDate);
    }

    /*
    public void downloadBlobFromBucket() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("The name of Bucket? ");
        String bucketName = scan.nextLine();
        System.out.println("The name of Blob? ");
        String blobName = scan.nextLine();
        System.out.println("What is the file pathname for downloading the Blob? ");
        String absFileName = scan.nextLine();
        Path downloadTo = Paths.get(absFileName);
        //System.out.println("download to: "+downloadTo);
        BlobId blobId = BlobId.of(bucketName, blobName);
        Path downloadTo = Paths.get(absFileName);
        Blob blob = storage.get(blobId);
        if (blob == null) {
            System.out.println("No such Blob exists !");
            return;
        }
        PrintStream writeTo = new PrintStream(Files.newOutputStream(downloadTo));
        if (blob.getSize() < 1_000_000) {
            // Blob is small read all its content in one request
            byte[] content = blob.getContent();
            writeTo.write(content);
        } else {
            // When Blob size is big or unknown use the blob's channel reader.
            try (ReadChannel reader = blob.reader()) {
                WritableByteChannel channel = Channels.newChannel(writeTo);
                ByteBuffer bytes = ByteBuffer.allocate(64 * 1024);
                while (reader.read(bytes) > 0) {
                    bytes.flip();
                    channel.write(bytes);
                    bytes.clear();
                }
            }
        }
        writeTo.close();
        System.out.println("Blob " + blobName + " downloaded to " + downloadTo);
    }*/
}
