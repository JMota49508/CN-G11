package grpcclientapp.operations;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.cloud.storage.Blob;
import com.google.api.core.ApiFuture;
import com.google.cloud.ReadChannel;
import com.google.cloud.WriteChannel;
import com.google.cloud.firestore.*;
import grpcclientapp.operations.services.Translate;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Operations {

    private static StorageOptions storageOptions = StorageOptions.getDefaultInstance();
    private static Storage storage = storageOptions.getService();
    private static Firestore db = null;
    private static String bucketName = "bucket-g11-cn-61d-europe";
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public Operations() {
        try {
            GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
            FirestoreOptions options = FirestoreOptions.newBuilder().setDatabaseId("image-storage")
                    .setCredentials(credentials).build();
            db = options.getService();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public void getImageLabels() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the document ID to get the labels");
        String id = scan.nextLine();
        DocumentReference docRef = db.collection("image-storage").document(id);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        Image img = document.toObject(Image.class);
        List<String> labels = Translate.translateLabels(img.labels, "en", "pt");
        img.print(labels);
    }*/

    public void getNamesFromDateAndLabel() throws ExecutionException, InterruptedException, ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the initial date with format (dd/mm/yyyy)");
        String initDate = scan.nextLine();
        System.out.println("Enter the final date with format (dd/mm/yyyy)");
        String finalDate = scan.nextLine();
        System.out.println("Enter a label");

        String label = Translate.translateLine(scan.nextLine(), "pt", "en");
        Query query = db.collection("image-storage")
                .whereGreaterThan("creationDate", Timestamp.from(formatter.parse(initDate).toInstant()))
                .whereLessThan("creationDate", Timestamp.from(formatter.parse(finalDate).toInstant()))
                .whereArrayContains("labels", label);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        System.out.println("Images uploaded between " + initDate + " and " + finalDate + " with label '" + label + "':");
        for (DocumentSnapshot doc : querySnapshot.get().getDocuments()) {
            System.out.println("- " + doc.get("name"));
        }
    }

    public void downloadImage() {

    }

    public File readFileBytes(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        String contentType = Files.probeContentType(path);
        byte[] input = Files.readAllBytes(path);
        return new File(fileName, input, contentType);
    }

    public String uploadBlobToBucket() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the Blob? ");
        String blobName = scan.nextLine();
        System.out.println("Enter the pathname of the file to uploiad? ");
        String absFileName = scan.nextLine();
        Path uploadFrom = Paths.get(absFileName);
        String contentType = Files.probeContentType(uploadFrom);
        BlobId blobId = BlobId.of(bucketName, blobName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(contentType).build();
        if (Files.size(uploadFrom) > 1_000_000) {
            // When content is not available or large (1MB or more) it is recommended
            // to write it in chunks via the blob's channel writer.
            try (WriteChannel writer = storage.writer(blobInfo)) {
                byte[] buffer = new byte[1024];
                try (InputStream input = Files.newInputStream(uploadFrom)) {
                    int limit;
                    while ((limit = input.read(buffer)) >= 0) {
                        try {
                            writer.write(ByteBuffer.wrap(buffer, 0, limit));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        } else {
            byte[] bytes = Files.readAllBytes(uploadFrom);
            // create the blob in one request.
            storage.create(blobInfo, bytes);
        }
        return blobName;
    }

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
    }

    private Date getCurrentDate() throws Exception {
        LocalDate currentDate = LocalDate.now();
        Date currentDateAsDate = java.sql.Date.valueOf(currentDate);
        String strDate = formatter.format(currentDateAsDate);
        return formatter.parse(strDate);
    }

}

