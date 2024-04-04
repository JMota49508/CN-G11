package grpcserverapp;

public class ShutdownHook extends Thread {
    io.grpc.Server svc;

    public ShutdownHook(io.grpc.Server svc) {
        this.svc = svc;
    }

    @Override
    public void run() {
        System.err.println("*shutdown gRPC server, because JVM is shutting down");
        try {
            // Initiates an orderly shutdown in which preexisting calls continue
            // but new calls are rejected. So we can clean and finish work
            svc.shutdown();
            svc.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace(System.err);
        }
        System.err.println("*** server shut down");
    }
}
