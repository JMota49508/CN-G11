package servicestubs;

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
public final class ServiceGrpc {

  private ServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "grpcservice.Service";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<servicestubs.InputFile,
      servicestubs.TextMessage> getSubmitFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "submitFile",
      requestType = servicestubs.InputFile.class,
      responseType = servicestubs.TextMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<servicestubs.InputFile,
      servicestubs.TextMessage> getSubmitFileMethod() {
    io.grpc.MethodDescriptor<servicestubs.InputFile, servicestubs.TextMessage> getSubmitFileMethod;
    if ((getSubmitFileMethod = ServiceGrpc.getSubmitFileMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getSubmitFileMethod = ServiceGrpc.getSubmitFileMethod) == null) {
          ServiceGrpc.getSubmitFileMethod = getSubmitFileMethod =
              io.grpc.MethodDescriptor.<servicestubs.InputFile, servicestubs.TextMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "submitFile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servicestubs.InputFile.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servicestubs.TextMessage.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("submitFile"))
              .build();
        }
      }
    }
    return getSubmitFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<servicestubs.TextMessage,
      servicestubs.ImageLabels> getGetImageLabelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getImageLabels",
      requestType = servicestubs.TextMessage.class,
      responseType = servicestubs.ImageLabels.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<servicestubs.TextMessage,
      servicestubs.ImageLabels> getGetImageLabelsMethod() {
    io.grpc.MethodDescriptor<servicestubs.TextMessage, servicestubs.ImageLabels> getGetImageLabelsMethod;
    if ((getGetImageLabelsMethod = ServiceGrpc.getGetImageLabelsMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getGetImageLabelsMethod = ServiceGrpc.getGetImageLabelsMethod) == null) {
          ServiceGrpc.getGetImageLabelsMethod = getGetImageLabelsMethod =
              io.grpc.MethodDescriptor.<servicestubs.TextMessage, servicestubs.ImageLabels>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getImageLabels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servicestubs.TextMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servicestubs.ImageLabels.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("getImageLabels"))
              .build();
        }
      }
    }
    return getGetImageLabelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<servicestubs.DatesAndLabel,
      servicestubs.ImageNames> getGetNamesFromDateAndLabelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getNamesFromDateAndLabel",
      requestType = servicestubs.DatesAndLabel.class,
      responseType = servicestubs.ImageNames.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<servicestubs.DatesAndLabel,
      servicestubs.ImageNames> getGetNamesFromDateAndLabelMethod() {
    io.grpc.MethodDescriptor<servicestubs.DatesAndLabel, servicestubs.ImageNames> getGetNamesFromDateAndLabelMethod;
    if ((getGetNamesFromDateAndLabelMethod = ServiceGrpc.getGetNamesFromDateAndLabelMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getGetNamesFromDateAndLabelMethod = ServiceGrpc.getGetNamesFromDateAndLabelMethod) == null) {
          ServiceGrpc.getGetNamesFromDateAndLabelMethod = getGetNamesFromDateAndLabelMethod =
              io.grpc.MethodDescriptor.<servicestubs.DatesAndLabel, servicestubs.ImageNames>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getNamesFromDateAndLabel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servicestubs.DatesAndLabel.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servicestubs.ImageNames.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("getNamesFromDateAndLabel"))
              .build();
        }
      }
    }
    return getGetNamesFromDateAndLabelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<servicestubs.TextMessage,
      servicestubs.Image> getDownloadImageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "downloadImage",
      requestType = servicestubs.TextMessage.class,
      responseType = servicestubs.Image.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<servicestubs.TextMessage,
      servicestubs.Image> getDownloadImageMethod() {
    io.grpc.MethodDescriptor<servicestubs.TextMessage, servicestubs.Image> getDownloadImageMethod;
    if ((getDownloadImageMethod = ServiceGrpc.getDownloadImageMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getDownloadImageMethod = ServiceGrpc.getDownloadImageMethod) == null) {
          ServiceGrpc.getDownloadImageMethod = getDownloadImageMethod =
              io.grpc.MethodDescriptor.<servicestubs.TextMessage, servicestubs.Image>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "downloadImage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servicestubs.TextMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servicestubs.Image.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("downloadImage"))
              .build();
        }
      }
    }
    return getDownloadImageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceStub>() {
        @java.lang.Override
        public ServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceStub(channel, callOptions);
        }
      };
    return ServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceBlockingStub>() {
        @java.lang.Override
        public ServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceBlockingStub(channel, callOptions);
        }
      };
    return ServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceFutureStub>() {
        @java.lang.Override
        public ServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceFutureStub(channel, callOptions);
        }
      };
    return ServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service contract operations 
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void submitFile(servicestubs.InputFile request,
        io.grpc.stub.StreamObserver<servicestubs.TextMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubmitFileMethod(), responseObserver);
    }

    /**
     */
    default void getImageLabels(servicestubs.TextMessage request,
        io.grpc.stub.StreamObserver<servicestubs.ImageLabels> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetImageLabelsMethod(), responseObserver);
    }

    /**
     */
    default void getNamesFromDateAndLabel(servicestubs.DatesAndLabel request,
        io.grpc.stub.StreamObserver<servicestubs.ImageNames> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNamesFromDateAndLabelMethod(), responseObserver);
    }

    /**
     */
    default void downloadImage(servicestubs.TextMessage request,
        io.grpc.stub.StreamObserver<servicestubs.Image> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDownloadImageMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Service.
   * <pre>
   * Service contract operations 
   * </pre>
   */
  public static abstract class ServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ServiceGrpc.bindService(this);
    }

    public abstract TextMessage submitFile(InputFile request);
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Service.
   * <pre>
   * Service contract operations 
   * </pre>
   */
  public static final class ServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ServiceStub> {
    private ServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceStub(channel, callOptions);
    }

    /**
     */
    public void submitFile(servicestubs.InputFile request,
        io.grpc.stub.StreamObserver<servicestubs.TextMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubmitFileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getImageLabels(servicestubs.TextMessage request,
        io.grpc.stub.StreamObserver<servicestubs.ImageLabels> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetImageLabelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getNamesFromDateAndLabel(servicestubs.DatesAndLabel request,
        io.grpc.stub.StreamObserver<servicestubs.ImageNames> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNamesFromDateAndLabelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void downloadImage(servicestubs.TextMessage request,
        io.grpc.stub.StreamObserver<servicestubs.Image> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDownloadImageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Service.
   * <pre>
   * Service contract operations 
   * </pre>
   */
  public static final class ServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ServiceBlockingStub> {
    private ServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public servicestubs.TextMessage submitFile(servicestubs.InputFile request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubmitFileMethod(), getCallOptions(), request);
    }

    /**
     */
    public servicestubs.ImageLabels getImageLabels(servicestubs.TextMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetImageLabelsMethod(), getCallOptions(), request);
    }

    /**
     */
    public servicestubs.ImageNames getNamesFromDateAndLabel(servicestubs.DatesAndLabel request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNamesFromDateAndLabelMethod(), getCallOptions(), request);
    }

    /**
     */
    public servicestubs.Image downloadImage(servicestubs.TextMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDownloadImageMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Service.
   * <pre>
   * Service contract operations 
   * </pre>
   */
  public static final class ServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ServiceFutureStub> {
    private ServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<servicestubs.TextMessage> submitFile(
        servicestubs.InputFile request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubmitFileMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<servicestubs.ImageLabels> getImageLabels(
        servicestubs.TextMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetImageLabelsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<servicestubs.ImageNames> getNamesFromDateAndLabel(
        servicestubs.DatesAndLabel request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNamesFromDateAndLabelMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<servicestubs.Image> downloadImage(
        servicestubs.TextMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDownloadImageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUBMIT_FILE = 0;
  private static final int METHODID_GET_IMAGE_LABELS = 1;
  private static final int METHODID_GET_NAMES_FROM_DATE_AND_LABEL = 2;
  private static final int METHODID_DOWNLOAD_IMAGE = 3;

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
        case METHODID_SUBMIT_FILE:
          serviceImpl.submitFile((servicestubs.InputFile) request,
              (io.grpc.stub.StreamObserver<servicestubs.TextMessage>) responseObserver);
          break;
        case METHODID_GET_IMAGE_LABELS:
          serviceImpl.getImageLabels((servicestubs.TextMessage) request,
              (io.grpc.stub.StreamObserver<servicestubs.ImageLabels>) responseObserver);
          break;
        case METHODID_GET_NAMES_FROM_DATE_AND_LABEL:
          serviceImpl.getNamesFromDateAndLabel((servicestubs.DatesAndLabel) request,
              (io.grpc.stub.StreamObserver<servicestubs.ImageNames>) responseObserver);
          break;
        case METHODID_DOWNLOAD_IMAGE:
          serviceImpl.downloadImage((servicestubs.TextMessage) request,
              (io.grpc.stub.StreamObserver<servicestubs.Image>) responseObserver);
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
          getSubmitFileMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              servicestubs.InputFile,
              servicestubs.TextMessage>(
                service, METHODID_SUBMIT_FILE)))
        .addMethod(
          getGetImageLabelsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              servicestubs.TextMessage,
              servicestubs.ImageLabels>(
                service, METHODID_GET_IMAGE_LABELS)))
        .addMethod(
          getGetNamesFromDateAndLabelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              servicestubs.DatesAndLabel,
              servicestubs.ImageNames>(
                service, METHODID_GET_NAMES_FROM_DATE_AND_LABEL)))
        .addMethod(
          getDownloadImageMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              servicestubs.TextMessage,
              servicestubs.Image>(
                service, METHODID_DOWNLOAD_IMAGE)))
        .build();
  }

  private static abstract class ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return servicestubs.ServiceContract.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Service");
    }
  }

  private static final class ServiceFileDescriptorSupplier
      extends ServiceBaseDescriptorSupplier {
    ServiceFileDescriptorSupplier() {}
  }

  private static final class ServiceMethodDescriptorSupplier
      extends ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServiceFileDescriptorSupplier())
              .addMethod(getSubmitFileMethod())
              .addMethod(getGetImageLabelsMethod())
              .addMethod(getGetNamesFromDateAndLabelMethod())
              .addMethod(getDownloadImageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
