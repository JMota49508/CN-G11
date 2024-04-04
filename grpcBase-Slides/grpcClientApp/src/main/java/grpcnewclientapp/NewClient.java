package grpcnewclientapp;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import servicestubs.IntervalNumbers;
import servicestubs.ServiceGrpc;

import java.util.Scanner;

public class NewClient {
    private static String svcIP = "34.147.208.121";
    private static int svcPort = 8000;
    private static ManagedChannel channel;
    private static ServiceGrpc.ServiceStub noBlockStub;

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
            noBlockStub = ServiceGrpc.newStub(channel);
            // Call service operations for example ping server
            PrimeNumbersStream stream1 = findPrimes(1, 100);
            PrimeNumbersStream stream2 = findPrimes(101, 200);
            PrimeNumbersStream stream3 = findPrimes(201, 300);
            PrimeNumbersStream stream4 = findPrimes(301, 400);
            PrimeNumbersStream stream5 = findPrimes(401, 500);
            while (!stream1.isCompleted() || !stream2.isCompleted() || !stream3.isCompleted()
                    || !stream4.isCompleted() || !stream5.isCompleted()) {
                System.out.println("Continue working until receive all prime numbers");
                Thread.sleep(500);
            }
        } catch (Exception ex) {
            System.out.println("Unhandled exception");
            ex.printStackTrace();
        }
    }

    static PrimeNumbersStream findPrimes(int start, int end) throws InterruptedException {
        // Asynchronous non blocking call
        PrimeNumbersStream primeStream = new PrimeNumbersStream();
        noBlockStub.findPrimes(IntervalNumbers.newBuilder().setStart(start).setEnd(end).build(), primeStream);
        return primeStream;
    }
}
