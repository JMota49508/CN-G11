package grpcserverapp;

import com.google.protobuf.Empty;
import forumstubs.ExistingTopics;
import forumstubs.ForumGrpc;
import forumstubs.ForumMessage;
import forumstubs.SubscribeUnSubscribe;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Service extends ForumGrpc.ForumImplBase {

    ConcurrentMap<String, ConcurrentMap<String, StreamObserver<ForumMessage>>> topicMap = new ConcurrentHashMap<>();

    public Service(int svcPort) {
        System.out.println("Service is available on port:" + svcPort);
    }

    @Override
    public void topicSubscribe(SubscribeUnSubscribe request, StreamObserver<ForumMessage> responseObserver) {
        String topicName = request.getTopicName();
        String usrName = request.getUsrName();
        topicMap.putIfAbsent(topicName, new ConcurrentHashMap<>());
        ConcurrentMap<String, StreamObserver<ForumMessage>> userMap = topicMap.get(topicName);
        userMap.put(usrName, responseObserver);
        responseObserver.onNext(ForumMessage.newBuilder().setFromUser(request.getUsrName())
                .setTopicName(request.getTopicName())
                .setTxtMsg("Hello!").build());
        System.out.println(request.getUsrName() + " subscribed to topic: " + request.getTopicName());
    }

    @Override
    public void topicUnSubscribe(SubscribeUnSubscribe request, StreamObserver<Empty> responseObserver) {
        String topicName = request.getTopicName();
        String usrName = request.getUsrName();
        ConcurrentMap<String, StreamObserver<ForumMessage>> userMap = topicMap.get(topicName);
        System.out.println(usrName + " unsubscribed from topic: " + topicName);
        userMap.remove(usrName);
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void getAllTopics(Empty request, StreamObserver<ExistingTopics> responseObserver) {
        System.out.println("getAllTopics called!");
        ExistingTopics topics = ExistingTopics.newBuilder().addAllTopicName(topicMap.keySet()).build();
        responseObserver.onNext(topics);
        responseObserver.onCompleted();
    }

    @Override
    public void publishMessage(ForumMessage request, StreamObserver<Empty> responseObserver) {
        System.out.println("publishMessage called!");
        String topicName = request.getTopicName();
        String fromUser = request.getFromUser();
        ConcurrentMap<String, StreamObserver<ForumMessage>> userMap = topicMap.get(topicName);
        userMap.forEach((usrName, usrObserver) -> {
            if (!usrName.equals(fromUser)) {
                usrObserver.onNext(request);
            }
        });
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }
}
