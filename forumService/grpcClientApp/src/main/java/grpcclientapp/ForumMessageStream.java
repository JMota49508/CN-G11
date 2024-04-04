package grpcclientapp;

import forumstubs.ForumMessage;
import io.grpc.stub.StreamObserver;


public class ForumMessageStream implements StreamObserver<ForumMessage> {
    boolean completed=false;
    @Override
    public void onNext(ForumMessage value) {
        System.out.println(value.getFromUser() + ": " + value.getTxtMsg());
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