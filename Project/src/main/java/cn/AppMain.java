package cn;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import cn.operations.Operations;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.cloud.storage.*;

import static cn.gcpservices.Labels.detectLabels;
import static cn.gcpservices.Translate.translateLabels;
import static cn.operations.Operations.*;

public class AppMain {

    static String bucketName = "bucket-g11-cn-61d-europe";
    static String PROJECT_ID = "CN2324-T1-G11";

    public static void main(String[] args) throws IOException {
        StorageOptions    storageOptions = StorageOptions.getDefaultInstance();
        Storage storage = storageOptions.getService();
        String projID = storageOptions.getProjectId();
        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
        FirestoreOptions options = FirestoreOptions.newBuilder().setDatabaseId("image-storage")
                .setCredentials(credentials).build();
        Firestore db = options.getService();

        Operations operations = new Operations(storage, db, bucketName);

        boolean end = false;
        while (!end) {
            try {
                int option = Menu();
                switch (option) {
                    case 1:
                        operations.submitFile();
                        break;
                    case 2:
                        operations.getImageLabels();
                        System.out.println();
                        break;
                    case 3:
                        operations.getNamesFromDateAndLabel();
                        System.out.println();
                        break;
                    case 4:
                        operations.downloadImage();
                        System.out.println();
                        break;
                    case 0:
                        end = true;
                }
            } catch (Exception ex) {
                System.out.println("Execution call Error  !");
                ex.printStackTrace();
            }
        }
    }

    private static int Menu() {
        int op;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("    MENU");
            System.out.println(" 1 - Submit File");
            System.out.println(" 2 - Get Image Labels");
            System.out.println(" 3 - Get Image Name by Date and Label");
            System.out.println(" 4 - Download Image");
            System.out.println(" 0 - Exit");
            System.out.println();
            System.out.println("Choose an Option");
            op = scan.nextInt();
        } while (!((op >= 0 && op <= 4)));
        return op;
    }
}
