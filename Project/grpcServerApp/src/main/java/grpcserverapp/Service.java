package grpcserverapp;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.WriteChannel;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import servicestubs.InputFile;
import servicestubs.ServiceGrpc;
import servicestubs.TextMessage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Service extends ServiceGrpc.ServiceImplBase {

    private static StorageOptions storageOptions = StorageOptions.getDefaultInstance();
    private static Storage storage = storageOptions.getService();
    private static String bucketName = "bucket-g11-cn-61d-europe";
    private static Firestore db = null;
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

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
            byte[] fileContent = request.getImage().toByteArray();
            // get the file content type
            String contentType = request.getContentType();
            // get the file name
            String fileName = request.getFileName();
            // create blob name
            String blobName = UUID.randomUUID().toString();

            String blobId = uploadFiletoBucket(fileContent, contentType, blobName);

            List<String> labels = Labels.detectLabels("gs://" + bucketName + "/" + blobName);
            insertDocuments(blobId, fileName, db, labels);
            return TextMessage.newBuilder().setTxt(blobId).build();
        } catch (Exception e) {
            return TextMessage.newBuilder().setTxt("Error: " + e.getMessage()).build();
        }
    }

    private static String uploadFiletoBucket(byte[] fileContent, String contentType, String blobName) throws IOException {
        BlobId blobId = BlobId.of(bucketName, blobName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(contentType).build();
        WriteChannel writer = storage.writer(blobInfo);
        byte[] buffer = new byte[1024];
        InputStream input = new ByteArrayInputStream(fileContent);
        int limit;
        while ((limit = input.read(buffer)) >= 0) {
            writer.write(ByteBuffer.wrap(buffer, 0, limit));
        }
        return blobId.getName();
    }

    private static void insertDocuments(String blobId, String fileName, Firestore db, List<String> labels) throws Exception {
        CollectionReference colRef = db.collection("image-storage");
        File file = new File();
        file.id = blobId;
        file.name = fileName;
        file.labels = labels;
        file.creationDate = getCurrentDate();
        DocumentReference docRef = colRef.document(blobId);
        docRef.set(file);
    }

    private static Date getCurrentDate() throws Exception {
        LocalDate currentDate = LocalDate.now();
        Date currentDateAsDate = java.sql.Date.valueOf(currentDate);
        String strDate = formatter.format(currentDateAsDate);
        return formatter.parse(strDate);
    }
}
