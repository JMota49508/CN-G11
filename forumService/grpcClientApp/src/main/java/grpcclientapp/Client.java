package grpcclientapp;

import com.google.protobuf.Empty;
import forumstubs.ExistingTopics;
import forumstubs.ForumGrpc;
import forumstubs.ForumMessage;
import forumstubs.SubscribeUnSubscribe;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Objects;
import java.util.Scanner;

public class Client {
    // generic ClientApp for Calling a grpc Service
    private static String svcIP = "localhost";
    private static int svcPort = 8000;
    private static ManagedChannel channel;
    private static ForumGrpc.ForumBlockingStub blockingStub;
    private static ForumGrpc.ForumStub noBlockStub;

    static String usrName;

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
            blockingStub = ForumGrpc.newBlockingStub(channel);
            noBlockStub = ForumGrpc.newStub(channel);
            // Call service operations for example ping server
            Scanner input = new Scanner(System.in);
            usrName = read("Enter user name: ", input);
            boolean end = false;
            while (!end) {
                try {
                    int option = Menu();
                    switch (option) {
                        case 1:
                            topicSubscribe();
                            break;
                        case 2:
                            getAllTopics();
                            break;
                        case 0:
                            System.exit(0);
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

    static void topicSubscribe() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        String topicName = read("Enter topic name: ", input);
        ForumMessageStream messageStream = new ForumMessageStream();
        EmptyStream emptyStream = new EmptyStream();
        System.out.println("Welcome to the chat room!");
        System.out.println("Enter message or 'Quit Topic' to exit.");
        noBlockStub.topicSubscribe(SubscribeUnSubscribe.newBuilder()
                .setTopicName(topicName).setUsrName(usrName).build(), messageStream);
        String message;
        Thread.sleep(3000);
        while (!messageStream.isCompleted()) {
            message = read(usrName + ": ", input);
            if (Objects.equals(message, "Quit Topic")) {
                noBlockStub.topicUnSubscribe(SubscribeUnSubscribe.newBuilder()
                        .setTopicName(topicName).setUsrName(usrName).build(), emptyStream);
                messageStream.onCompleted();
                System.out.println("You have left the chat room.\n\n\n\n\n\n\n\n\n\n\n");
            } else {
                noBlockStub.publishMessage(
                        ForumMessage.newBuilder()
                                .setTopicName(topicName)
                                .setFromUser(usrName)
                                .setTxtMsg(message).build(),
                        emptyStream
                );
            }
        }
    }

    static void getAllTopics() {
        ExistingTopics topics = blockingStub.getAllTopics(Empty.getDefaultInstance());
        System.out.println("\nTopics:");
        topics.getTopicNameList().forEach(System.out::println);
        System.out.println("\n\n");
    }

    private static int Menu() {
        int op;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("    MENU");
            System.out.println(" 1 - Subscribe to topic");
            System.out.println(" 2 - Get all topics");
            System.out.println(" 0 - Exit");
            System.out.println();
            System.out.println("Choose an Option?");
            op = scan.nextInt();
        } while (!((op >= 0 && op <= 2)));
        return op;
    }

    private static String read(String msg, Scanner input) {
        System.out.print(msg);
        return input.nextLine();
    }
}
