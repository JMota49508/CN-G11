package grpcclientapp;

import com.google.protobuf.Empty;
import forumstubs.ForumMessage;
import io.grpc.stub.StreamObserver;

public class EmptyStream implements StreamObserver<Empty> {
    boolean completed=false;
    @Override
    public void onNext(Empty value) {}
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