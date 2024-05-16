package grpcclientapp;

import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import servicestubs.AddResult;
import servicestubs.IntNumber;


public class EvenNumbersStream implements StreamObserver<IntNumber> {
    boolean completed=false;
    @Override
    public void onNext(IntNumber reply) {
        System.out.println("More one even number:"+reply.getIntnumber());
    }
    @Override
    public void onError(Throwable throwable) {
        System.out.println("Completed with error:"+throwable.getMessage());
        completed=true;
    }
    @Override
    public void onCompleted() {
        System.out.println("Even numbers completed");
        completed=true;
    }

    public boolean isCompleted() {
        return completed;
    }
}
