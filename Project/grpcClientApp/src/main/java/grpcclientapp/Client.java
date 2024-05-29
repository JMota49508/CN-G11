package grpcclientapp;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import scalabilitystubs.ResizeRequest;
import scalabilitystubs.ScalabilityServiceGrpc;
import servicestubs.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Scanner;

public class Client {
    // generic ClientApp for Calling a grpc Service
    private static String svcIP = "localhost";
    private static int svcPort = 8000;
    private static ManagedChannel channel;
    private static ServiceGrpc.ServiceBlockingStub blockingStub;
    private static ServiceGrpc.ServiceStub nonBlockingStub;
    private static ScalabilityServiceGrpc.ScalabilityServiceBlockingStub scalabilityBlockingStub;
    private final static Scanner scanner = new Scanner(System.in);
    static String cfURL = "https://europe-west2-cn2324-t1-g11.cloudfunctions.net/cn-http-functions";

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
            nonBlockingStub = ServiceGrpc.newStub(channel);
            scalabilityBlockingStub = scalabilitystubs.ScalabilityServiceGrpc.newBlockingStub(channel);
            // Call service operations for example ping server
            boolean end = false;
            while (!end) {
                try {
                    int option = Menu();
                    switch (option) {
                        case 1:
                            lookUpIpCall();
                            break;
                        case 2:
                            resizeServerInstances();
                            break;
                        case 3:
                            resizeAppInstances();
                            break;
                        case 4:
                            submitFileCall();
                            break;
                        case 5:
                            getImageLabelsCall();
                            break;
                        case 6:
                            getNamesFromDateAndLabelCall();
                            break;
                        case 7:
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

    static void lookUpIpCall() {
        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(cfURL))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) System.out.println(response.body());
            String choice = read("Of the above choose one VM to connect to (TYPE THE IP ADDRESS). If you want " +
                    "to keep the same just press enter:", scanner);
            if (choice.length() > 0) {
                svcIP = choice;
                updateChannel(svcIP, svcPort);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void updateChannel(String newIP, int newPort) {
        // Shut down the old channel
        if (channel != null && !channel.isShutdown()) {
            channel.shutdown();
        }

        // Create a new channel with the new IP and port
        channel = ManagedChannelBuilder.forAddress(newIP, newPort)
                .usePlaintext()
                .build();

        // Update the stubs with the new channel
        blockingStub = ServiceGrpc.newBlockingStub(channel);
        nonBlockingStub = ServiceGrpc.newStub(channel);
        scalabilityBlockingStub = scalabilitystubs.ScalabilityServiceGrpc.newBlockingStub(channel);
    }

    static void resizeServerInstances() {
        String size = read("Enter a new number of extra instances for the server: ", scanner);
        ResizeRequest request = ResizeRequest.newBuilder()
                .setProjectId("cn2324-t1-g11")
                .setZone("europe-west2-c")
                .setInstanceGroup("grpc-server-group")
                .setSize(Integer.parseInt(size))
                .build();
        scalabilityBlockingStub.resizeInstance(request);
    }

    static void resizeAppInstances() {
        String size = read("Enter a new number of instances for the LabelsApp: ", scanner);
        ResizeRequest request = ResizeRequest.newBuilder()
                .setProjectId("cn2324-t1-g11")
                .setZone("europe-west2-c")
                .setInstanceGroup("labels-app-group")
                .setSize(Integer.parseInt(size))
                .build();
        scalabilityBlockingStub.resizeInstance(request);
    }

    static void submitFileCall() throws IOException {
        String fileName = read("Enter the name of the file you want to upload: ", scanner);
        SimpleFile fileBytes = readFileBytes(fileName);
        SubmitFileStream response = new SubmitFileStream();
        nonBlockingStub.submitFile(InputFile.newBuilder()
                        .setFile(ByteString.copyFrom(fileBytes.bytes))
                        .setContentType(fileBytes.contentType)
                        .setFileName(fileName)
                        .build(),
                response
        );
        /*while (!response.isCompleted()) {
            System.out.println("Uploading file...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }

    static void getImageLabelsCall() {
        String docID = read("Enter the document ID to get the labels", scanner);
        FileLabels labels = blockingStub.getImageLabels(TextMessage
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
                .setLabel(Base64.getEncoder().encodeToString(label.getBytes(StandardCharsets.UTF_8)))
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
        String absFileName = read("What is the name you want to give to the Blob you are downloading: ", scanner);
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
            System.out.println(" 1 - Lookup active VM IPs");
            System.out.println(" 2 - Resize Server Instances");
            System.out.println(" 3 - Resize App Instances");
            System.out.println(" 4 - Submit File");
            System.out.println(" 5 - Get Image Labels");
            System.out.println(" 6 - Get Image Name by Date and Label");
            System.out.println(" 7 - Download Image");
            System.out.println(" 99 - Exit");
            System.out.println();
            System.out.println("Choose an Option");
            op = scan.nextInt();
        } while (!((op >= 1 && op <= 6) || op == 99));
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
