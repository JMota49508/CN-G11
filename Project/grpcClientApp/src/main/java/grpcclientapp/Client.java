package grpcclientapp;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import servicestubs.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Client {
    // generic ClientApp for Calling a grpc Service
    private static String svcIP = "localhost";
    private static int svcPort = 8000;
    private static ManagedChannel channel;
    private static ServiceGrpc.ServiceBlockingStub blockingStub;
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            if (args.length == 2) {
                svcIP = args[0];
                svcPort = Integer.parseInt(args[1]);
            }
            System.out.println("connect to " + svcIP + ":" + svcPort);
            channel = ManagedChannelBuilder.forAddress(svcIP, svcPort)
                    // Channels are secure by default (via SSL/TLS).
                    // For the example we disable TLS to avoid
                    // needing certificates.
                    .usePlaintext()
                    .build();
            blockingStub = ServiceGrpc.newBlockingStub(channel);
            // Call service operations for example ping server
            boolean end = false;
            while (!end) {
                try {
                    int option = Menu();
                    switch (option) {
                        case 1:
                            submitFileCall();
                            break;
                        case 2:
                            getImageLabelsCall();
                            break;
                        case 3:
                            getNamesFromDateAndLabelCall();
                            break;
                        case 4:
                            downloadImageCall();
                            break;
                        case 99:
                            end = true;
                            break;
                    }
                } catch (Exception ex) {
                    System.out.println("Execution call Error  !");
                    ex.printStackTrace();
                }
            }
            read("prima enter to end", new Scanner(System.in));
            System.exit(0);
        } catch (Exception ex) {
            System.out.println("Unhandled exception");
            ex.printStackTrace();
        }
    }

    static void submitFileCall() throws IOException {
        String fileName = read("Enter the name of the file you want to upload: ", scanner);
        SimpleFile fileBytes = readFileBytes(fileName);
        TextMessage blobId = blockingStub.submitFile(InputFile.newBuilder()
                .setFile(ByteString.copyFrom(fileBytes.bytes))
                .setContentType(fileBytes.contentType)
                .setFileName(fileName)
                .build()
        );
        System.out.println("File was submitted successfully!");
        System.out.println("File Id: " + blobId.getTxt());
    }

    static void getImageLabelsCall() {
        String docID = read("Enter the document ID to get the labels", scanner);
        FileLabels labels = blockingStub
                .getImageLabels(TextMessage
                        .newBuilder()
                        .setTxt(docID)
                        .build()
                );
        System.out.println("Labels of the document:");
        for (int i = 0; i < labels.getLabelsCount(); i++) {
            System.out.println("- " + labels.getLabels(i));
        }
    }

    static void getNamesFromDateAndLabelCall() {
        String initDate = read("Enter the initial date with format (dd/mm/yyyy): ", scanner);
        String finalDate = read("Enter the final date with format (dd/mm/yyyy): ", scanner);
        String label = read("Enter a label: ", scanner);
        FileNames names = blockingStub.getNamesFromDateAndLabel(DatesAndLabel
                .newBuilder()
                .setLabel(label)
                .setFinalDate(finalDate)
                .setInitDate(initDate).build()
        );
        System.out.println("Images uploaded between " + initDate + " and " + finalDate + " with label '" + label + "':");
        for (int i = 0; i < names.getNamesCount(); i++) {
            System.out.println("- " + names.getNames(i));
        }
    }

    static void downloadImageCall() {
        String blobId = read("Enter the ID of the file you want to download: ", scanner);
        String absFileName = read("What is the file pathname for downloading the Blob: ", scanner);
        DownloadedFile file = blockingStub.downloadFile(TextMessage
                .newBuilder()
                .setTxt(blobId)
                .build()
        );
        Path downloadTo = Paths.get(absFileName);
        try {
            PrintStream writeTo = new PrintStream(Files.newOutputStream(downloadTo));
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(file.getFile().toByteArray());
            ReadableByteChannel reader = Channels.newChannel(byteArrayInputStream);
            WritableByteChannel channel = Channels.newChannel(writeTo);
            ByteBuffer bytes = ByteBuffer.allocate(64 * 1024);
            while (reader.read(bytes) > 0) {
                bytes.flip();
                channel.write(bytes);
                bytes.clear();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
            System.out.println(" 99 - Exit");
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

    private static SimpleFile readFileBytes(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        String contentType = Files.probeContentType(path);
        byte[] input = Files.readAllBytes(path);
        return new SimpleFile(fileName, input, contentType);
    }
}
