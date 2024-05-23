package grpcclientapp;

import io.grpc.stub.StreamObserver;
import servicestubs.TextMessage;

public class SubmitFileStream implements StreamObserver<TextMessage> {

    boolean completed=false;

    @Override
    public void onNext(TextMessage value) {
        System.out.println("Message: " + value);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Completed with error:"+throwable.getMessage());
        completed=true;
    }

    @Override
    public void onCompleted() {
        completed=true;
    }

    public boolean isCompleted() {
        return completed;
    }
}
