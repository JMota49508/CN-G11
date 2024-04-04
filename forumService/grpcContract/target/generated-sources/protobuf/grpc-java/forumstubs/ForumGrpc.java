package forumstubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service contract operations 
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.0)",
    comments = "Source: ServiceContract.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ForumGrpc {

  private ForumGrpc() {}

  public static final java.lang.String SERVICE_NAME = "grpcservice.Forum";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<forumstubs.SubscribeUnSubscribe,
      forumstubs.ForumMessage> getTopicSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "topicSubscribe",
      requestType = forumstubs.SubscribeUnSubscribe.class,
      responseType = forumstubs.ForumMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<forumstubs.SubscribeUnSubscribe,
      forumstubs.ForumMessage> getTopicSubscribeMethod() {
    io.grpc.MethodDescriptor<forumstubs.SubscribeUnSubscribe, forumstubs.ForumMessage> getTopicSubscribeMethod;
    if ((getTopicSubscribeMethod = ForumGrpc.getTopicSubscribeMethod) == null) {
      synchronized (ForumGrpc.class) {
        if ((getTopicSubscribeMethod = ForumGrpc.getTopicSubscribeMethod) == null) {
          ForumGrpc.getTopicSubscribeMethod = getTopicSubscribeMethod =
              io.grpc.MethodDescriptor.<forumstubs.SubscribeUnSubscribe, forumstubs.ForumMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "topicSubscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  forumstubs.SubscribeUnSubscribe.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  forumstubs.ForumMessage.getDefaultInstance()))
              .setSchemaDescriptor(new ForumMethodDescriptorSupplier("topicSubscribe"))
              .build();
        }
      }
    }
    return getTopicSubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<forumstubs.SubscribeUnSubscribe,
      com.google.protobuf.Empty> getTopicUnSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "topicUnSubscribe",
      requestType = forumstubs.SubscribeUnSubscribe.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<forumstubs.SubscribeUnSubscribe,
      com.google.protobuf.Empty> getTopicUnSubscribeMethod() {
    io.grpc.MethodDescriptor<forumstubs.SubscribeUnSubscribe, com.google.protobuf.Empty> getTopicUnSubscribeMethod;
    if ((getTopicUnSubscribeMethod = ForumGrpc.getTopicUnSubscribeMethod) == null) {
      synchronized (ForumGrpc.class) {
        if ((getTopicUnSubscribeMethod = ForumGrpc.getTopicUnSubscribeMethod) == null) {
          ForumGrpc.getTopicUnSubscribeMethod = getTopicUnSubscribeMethod =
              io.grpc.MethodDescriptor.<forumstubs.SubscribeUnSubscribe, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "topicUnSubscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  forumstubs.SubscribeUnSubscribe.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ForumMethodDescriptorSupplier("topicUnSubscribe"))
              .build();
        }
      }
    }
    return getTopicUnSubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      forumstubs.ExistingTopics> getGetAllTopicsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllTopics",
      requestType = com.google.protobuf.Empty.class,
      responseType = forumstubs.ExistingTopics.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      forumstubs.ExistingTopics> getGetAllTopicsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, forumstubs.ExistingTopics> getGetAllTopicsMethod;
    if ((getGetAllTopicsMethod = ForumGrpc.getGetAllTopicsMethod) == null) {
      synchronized (ForumGrpc.class) {
        if ((getGetAllTopicsMethod = ForumGrpc.getGetAllTopicsMethod) == null) {
          ForumGrpc.getGetAllTopicsMethod = getGetAllTopicsMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, forumstubs.ExistingTopics>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllTopics"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  forumstubs.ExistingTopics.getDefaultInstance()))
              .setSchemaDescriptor(new ForumMethodDescriptorSupplier("getAllTopics"))
              .build();
        }
      }
    }
    return getGetAllTopicsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<forumstubs.ForumMessage,
      com.google.protobuf.Empty> getPublishMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "publishMessage",
      requestType = forumstubs.ForumMessage.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<forumstubs.ForumMessage,
      com.google.protobuf.Empty> getPublishMessageMethod() {
    io.grpc.MethodDescriptor<forumstubs.ForumMessage, com.google.protobuf.Empty> getPublishMessageMethod;
    if ((getPublishMessageMethod = ForumGrpc.getPublishMessageMethod) == null) {
      synchronized (ForumGrpc.class) {
        if ((getPublishMessageMethod = ForumGrpc.getPublishMessageMethod) == null) {
          ForumGrpc.getPublishMessageMethod = getPublishMessageMethod =
              io.grpc.MethodDescriptor.<forumstubs.ForumMessage, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "publishMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  forumstubs.ForumMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ForumMethodDescriptorSupplier("publishMessage"))
              .build();
        }
      }
    }
    return getPublishMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ForumStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ForumStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ForumStub>() {
        @java.lang.Override
        public ForumStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ForumStub(channel, callOptions);
        }
      };
    return ForumStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ForumBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ForumBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ForumBlockingStub>() {
        @java.lang.Override
        public ForumBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ForumBlockingStub(channel, callOptions);
        }
      };
    return ForumBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ForumFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ForumFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ForumFutureStub>() {
        @java.lang.Override
        public ForumFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ForumFutureStub(channel, callOptions);
        }
      };
    return ForumFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service contract operations 
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * subscribe a topic
     * </pre>
     */
    default void topicSubscribe(forumstubs.SubscribeUnSubscribe request,
        io.grpc.stub.StreamObserver<forumstubs.ForumMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTopicSubscribeMethod(), responseObserver);
    }

    /**
     * <pre>
     * unsubscribe a topic
     * </pre>
     */
    default void topicUnSubscribe(forumstubs.SubscribeUnSubscribe request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTopicUnSubscribeMethod(), responseObserver);
    }

    /**
     * <pre>
     * get all topics in server
     * </pre>
     */
    default void getAllTopics(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<forumstubs.ExistingTopics> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllTopicsMethod(), responseObserver);
    }

    /**
     * <pre>
     * send a message to a topic
     * </pre>
     */
    default void publishMessage(forumstubs.ForumMessage request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPublishMessageMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Forum.
   * <pre>
   * Service contract operations 
   * </pre>
   */
  public static abstract class ForumImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ForumGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Forum.
   * <pre>
   * Service contract operations 
   * </pre>
   */
  public static final class ForumStub
      extends io.grpc.stub.AbstractAsyncStub<ForumStub> {
    private ForumStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ForumStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ForumStub(channel, callOptions);
    }

    /**
     * <pre>
     * subscribe a topic
     * </pre>
     */
    public void topicSubscribe(forumstubs.SubscribeUnSubscribe request,
        io.grpc.stub.StreamObserver<forumstubs.ForumMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getTopicSubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * unsubscribe a topic
     * </pre>
     */
    public void topicUnSubscribe(forumstubs.SubscribeUnSubscribe request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTopicUnSubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * get all topics in server
     * </pre>
     */
    public void getAllTopics(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<forumstubs.ExistingTopics> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllTopicsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * send a message to a topic
     * </pre>
     */
    public void publishMessage(forumstubs.ForumMessage request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPublishMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Forum.
   * <pre>
   * Service contract operations 
   * </pre>
   */
  public static final class ForumBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ForumBlockingStub> {
    private ForumBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ForumBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ForumBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * subscribe a topic
     * </pre>
     */
    public java.util.Iterator<forumstubs.ForumMessage> topicSubscribe(
        forumstubs.SubscribeUnSubscribe request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getTopicSubscribeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * unsubscribe a topic
     * </pre>
     */
    public com.google.protobuf.Empty topicUnSubscribe(forumstubs.SubscribeUnSubscribe request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTopicUnSubscribeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * get all topics in server
     * </pre>
     */
    public forumstubs.ExistingTopics getAllTopics(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllTopicsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * send a message to a topic
     * </pre>
     */
    public com.google.protobuf.Empty publishMessage(forumstubs.ForumMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPublishMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Forum.
   * <pre>
   * Service contract operations 
   * </pre>
   */
  public static final class ForumFutureStub
      extends io.grpc.stub.AbstractFutureStub<ForumFutureStub> {
    private ForumFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ForumFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ForumFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * unsubscribe a topic
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> topicUnSubscribe(
        forumstubs.SubscribeUnSubscribe request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTopicUnSubscribeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * get all topics in server
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<forumstubs.ExistingTopics> getAllTopics(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllTopicsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * send a message to a topic
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> publishMessage(
        forumstubs.ForumMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPublishMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TOPIC_SUBSCRIBE = 0;
  private static final int METHODID_TOPIC_UN_SUBSCRIBE = 1;
  private static final int METHODID_GET_ALL_TOPICS = 2;
  private static final int METHODID_PUBLISH_MESSAGE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TOPIC_SUBSCRIBE:
          serviceImpl.topicSubscribe((forumstubs.SubscribeUnSubscribe) request,
              (io.grpc.stub.StreamObserver<forumstubs.ForumMessage>) responseObserver);
          break;
        case METHODID_TOPIC_UN_SUBSCRIBE:
          serviceImpl.topicUnSubscribe((forumstubs.SubscribeUnSubscribe) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_ALL_TOPICS:
          serviceImpl.getAllTopics((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<forumstubs.ExistingTopics>) responseObserver);
          break;
        case METHODID_PUBLISH_MESSAGE:
          serviceImpl.publishMessage((forumstubs.ForumMessage) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getTopicSubscribeMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              forumstubs.SubscribeUnSubscribe,
              forumstubs.ForumMessage>(
                service, METHODID_TOPIC_SUBSCRIBE)))
        .addMethod(
          getTopicUnSubscribeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              forumstubs.SubscribeUnSubscribe,
              com.google.protobuf.Empty>(
                service, METHODID_TOPIC_UN_SUBSCRIBE)))
        .addMethod(
          getGetAllTopicsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              forumstubs.ExistingTopics>(
                service, METHODID_GET_ALL_TOPICS)))
        .addMethod(
          getPublishMessageMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              forumstubs.ForumMessage,
              com.google.protobuf.Empty>(
                service, METHODID_PUBLISH_MESSAGE)))
        .build();
  }

  private static abstract class ForumBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ForumBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return forumstubs.ServiceContract.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Forum");
    }
  }

  private static final class ForumFileDescriptorSupplier
      extends ForumBaseDescriptorSupplier {
    ForumFileDescriptorSupplier() {}
  }

  private static final class ForumMethodDescriptorSupplier
      extends ForumBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ForumMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ForumGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ForumFileDescriptorSupplier())
              .addMethod(getTopicSubscribeMethod())
              .addMethod(getTopicUnSubscribeMethod())
              .addMethod(getGetAllTopicsMethod())
              .addMethod(getPublishMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
