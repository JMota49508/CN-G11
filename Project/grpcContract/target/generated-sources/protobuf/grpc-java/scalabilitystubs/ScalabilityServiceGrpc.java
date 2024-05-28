package scalabilitystubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service contract operations
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.0)",
    comments = "Source: ScalabilityContract.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ScalabilityServiceGrpc {

  private ScalabilityServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "grpcservice.ScalabilityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<scalabilitystubs.ResizeRequest,
      com.google.protobuf.Empty> getResizeInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "resizeInstance",
      requestType = scalabilitystubs.ResizeRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<scalabilitystubs.ResizeRequest,
      com.google.protobuf.Empty> getResizeInstanceMethod() {
    io.grpc.MethodDescriptor<scalabilitystubs.ResizeRequest, com.google.protobuf.Empty> getResizeInstanceMethod;
    if ((getResizeInstanceMethod = ScalabilityServiceGrpc.getResizeInstanceMethod) == null) {
      synchronized (ScalabilityServiceGrpc.class) {
        if ((getResizeInstanceMethod = ScalabilityServiceGrpc.getResizeInstanceMethod) == null) {
          ScalabilityServiceGrpc.getResizeInstanceMethod = getResizeInstanceMethod =
              io.grpc.MethodDescriptor.<scalabilitystubs.ResizeRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "resizeInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  scalabilitystubs.ResizeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ScalabilityServiceMethodDescriptorSupplier("resizeInstance"))
              .build();
        }
      }
    }
    return getResizeInstanceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ScalabilityServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ScalabilityServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ScalabilityServiceStub>() {
        @java.lang.Override
        public ScalabilityServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ScalabilityServiceStub(channel, callOptions);
        }
      };
    return ScalabilityServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ScalabilityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ScalabilityServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ScalabilityServiceBlockingStub>() {
        @java.lang.Override
        public ScalabilityServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ScalabilityServiceBlockingStub(channel, callOptions);
        }
      };
    return ScalabilityServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ScalabilityServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ScalabilityServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ScalabilityServiceFutureStub>() {
        @java.lang.Override
        public ScalabilityServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ScalabilityServiceFutureStub(channel, callOptions);
        }
      };
    return ScalabilityServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service contract operations
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void resizeInstance(scalabilitystubs.ResizeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResizeInstanceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ScalabilityService.
   * <pre>
   * Service contract operations
   * </pre>
   */
  public static abstract class ScalabilityServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ScalabilityServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ScalabilityService.
   * <pre>
   * Service contract operations
   * </pre>
   */
  public static final class ScalabilityServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ScalabilityServiceStub> {
    private ScalabilityServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScalabilityServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ScalabilityServiceStub(channel, callOptions);
    }

    /**
     */
    public void resizeInstance(scalabilitystubs.ResizeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResizeInstanceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ScalabilityService.
   * <pre>
   * Service contract operations
   * </pre>
   */
  public static final class ScalabilityServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ScalabilityServiceBlockingStub> {
    private ScalabilityServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScalabilityServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ScalabilityServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty resizeInstance(scalabilitystubs.ResizeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResizeInstanceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ScalabilityService.
   * <pre>
   * Service contract operations
   * </pre>
   */
  public static final class ScalabilityServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ScalabilityServiceFutureStub> {
    private ScalabilityServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScalabilityServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ScalabilityServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> resizeInstance(
        scalabilitystubs.ResizeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResizeInstanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RESIZE_INSTANCE = 0;

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
        case METHODID_RESIZE_INSTANCE:
          serviceImpl.resizeInstance((scalabilitystubs.ResizeRequest) request,
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
          getResizeInstanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              scalabilitystubs.ResizeRequest,
              com.google.protobuf.Empty>(
                service, METHODID_RESIZE_INSTANCE)))
        .build();
  }

  private static abstract class ScalabilityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ScalabilityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return scalabilitystubs.ScalabilityContract.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ScalabilityService");
    }
  }

  private static final class ScalabilityServiceFileDescriptorSupplier
      extends ScalabilityServiceBaseDescriptorSupplier {
    ScalabilityServiceFileDescriptorSupplier() {}
  }

  private static final class ScalabilityServiceMethodDescriptorSupplier
      extends ScalabilityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ScalabilityServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ScalabilityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ScalabilityServiceFileDescriptorSupplier())
              .addMethod(getResizeInstanceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
