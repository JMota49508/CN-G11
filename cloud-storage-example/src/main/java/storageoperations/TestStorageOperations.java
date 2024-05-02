package storageoperations;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;


import java.io.FileInputStream;
import java.util.Scanner;

public class TestStorageOperations {

    static int Menu() {
        Scanner scan = new Scanner(System.in);
        int option;
        do {
            System.out.println("######## MENU ##########");
            System.out.println("Options for Google Storage Operations:");
            System.out.println(" 0: List Buckets in Project");
            System.out.println(" 1: Create a new Bucket");
            System.out.println(" 2: Upload Blob to Bucket");
            System.out.println(" 3: Download Blob from Bucket");
            System.out.println(" 4: Delete a Bucket");
            System.out.println("..........");
            System.out.println("99: Exit");
            System.out.print("Enter an Option: ");
            option = scan.nextInt();
        } while (!((option >= 0 && option <= 4) || option == 99));
        return option;
    }

    public static void main(String[] args) throws Exception {
        // Service Accounts:
        // option 2 - Use the environment variable GOOGLE_APPLICATION_CREDENTIALS
        //            to point to the file name with the service account private key
        //      ex:
        //      $ set GOOGLE_APPLICATION_CREDENTIALS = c:\keys\my-service-account.json
        //
        StorageOptions    storageOptions = StorageOptions.getDefaultInstance();
        Storage storage = storageOptions.getService();
        String projID = storageOptions.getProjectId();
        if (projID != null) System.out.println("Current Project ID:" + projID);
        else {
            System.out.println("The environment variable GOOGLE_APPLICATION_CREDENTIALS isn't well defined!!");
            System.exit(-1);
        }
        StorageOperations soper = new StorageOperations(storage);
        boolean end = false;
        while (!end) {
            try {
                int option = Menu();
                switch (option) {
                    case 0:
                        soper.listBuckets(projID);
                        break;
                    case 1:
                        soper.createBucket();
                        break;
                    case 2:
                        soper.uploadBlobToBucket();
                        break;
                    case 3:
                        soper.downloadBlobFromBucket();
                        break;
                    case 4:
                        soper.deleteBucket();
                        break;
                    // TODO: Other Operations
                    //
                    case 99:
                        System.exit(0);
                }
            } catch (Exception ex) {
                System.out.println("Error executing operations!");
                ex.printStackTrace();
            }
        }
    }
}
