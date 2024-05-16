package grpcclientapp;

import com.google.protobuf.ByteString;
import grpcclientapp.operations.File;
import grpcclientapp.operations.Operations;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import servicestubs.*;

import java.io.IOException;
import java.util.*;

public class Client {
    // generic ClientApp for Calling a grpc Service
    private static String svcIP = "localhost";
    private static int svcPort = 8000;
    private static ManagedChannel channel;
    private static ServiceGrpc.ServiceBlockingStub blockingStub;
    private static ServiceGrpc.ServiceStub noBlockStub;
    private static Operations service = new Operations();

    public static void main(String[] args) {
        try {
            if (args.length == 2) {
                svcIP = args[0]; svcPort = Integer.parseInt(args[1]);
            }
            System.out.println("connect to " + svcIP + ":" + svcPort);
            channel = ManagedChannelBuilder.forAddress(svcIP, svcPort)
                    // Channels are secure by default (via SSL/TLS).
                    // For the example we disable TLS to avoid
                    // needing certificates.
                    .usePlaintext()
                    .build();
            blockingStub = ServiceGrpc.newBlockingStub(channel);
            noBlockStub = ServiceGrpc.newStub(channel);
            // Call service operations for example ping server
            boolean end = false;
            while (!end) {
                try {
                    int option = Menu();
                    switch (option) {
                        case 1:
                            submitFileCall();  break;
                        case 2:
                            getImageLabelsCall(); break;
                        case 3:
                            getNamesFromDateAndLabelCall(); break;
                        case 4:
                            downloadImageCall(); break;
                        case 99:  System.exit(0);
                    }
                } catch (Exception ex) {
                    System.out.println("Execution call Error  !");
                    ex.printStackTrace();
                }
            }
            read("prima enter to end", new Scanner(System.in));
        } catch (Exception ex) {
            System.out.println("Unhandled exception");
            ex.printStackTrace();
        }
    }

    static void submitFileCall() throws IOException {
        //ping server
        Scanner scanner = new Scanner(System.in);
        String fileName = read("Enter the name of the file you want to upload: ", scanner);
        File fileBytes = service.readFileBytes(fileName);
        var x = blockingStub.submitFile(InputFile.newBuilder()
                .setImage(ByteString.copyFrom(fileBytes.bytes))
                .setContentType(fileBytes.contentType)
                .setFileName(fileName)
                .build()
        );
    }

    static void getImageLabelsCall() {
        Scanner scanner = new Scanner(System.in);
        String docID = read("Enter the document ID to get the labels", scanner);
        ImageLabels labels = blockingStub
                .getImageLabels(
                        TextMessage
                        .newBuilder()
                        .setTxt(docID)
                        .build()
        );

    }

    static void getNamesFromDateAndLabelCall() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String initDate = read("Enter the initial date with format (dd/mm/yyyy): ", scanner);
        String finalDate = read("Enter the final date with format (dd/mm/yyyy): ", scanner);
        String label = read("Enter a label: ", scanner);
        ImageNames images = blockingStub.getNamesFromDateAndLabel(DatesAndLabel.
                newBuilder().
                setLabel(label).
                setFinalDate(finalDate)
                .setInitDate(initDate).build()
        );
    }

    static void downloadImageCall() {

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
        } while (!((op >= 1 && op <= 5) || op == 99));
        return op;
    }

    private static String read(String msg, Scanner input) {
        System.out.println(msg);
        return input.nextLine();
    }
}
