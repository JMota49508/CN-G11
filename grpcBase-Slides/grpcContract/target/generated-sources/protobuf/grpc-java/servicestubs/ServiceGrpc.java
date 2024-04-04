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
  private static volatile io.grpc.MethodDescriptor<servicestubs.ProtoVoid,
      servicestubs.TextMessage> getIsAliveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "isAlive",
      requestType = servicestubs.ProtoVoid.class,
      responseType = servicestubs.TextMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<servicestubs.ProtoVoid,
      servicestubs.TextMessage> getIsAliveMethod() {
    io.grpc.MethodDescriptor<servicestubs.ProtoVoid, servicestubs.TextMessage> getIsAliveMethod;
    if ((getIsAliveMethod = ServiceGrpc.getIsAliveMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getIsAliveMethod = ServiceGrpc.getIsAliveMethod) == null) {
          ServiceGrpc.getIsAliveMethod = getIsAliveMethod =
              io.grpc.MethodDescriptor.<servicestubs.ProtoVoid, servicestubs.TextMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "isAlive"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servicestubs.ProtoVoid.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servicestubs.TextMessage.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("isAlive"))
              .build();
        }
      }
    }
    return getIsAliveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<servicestubs.IntNumber,
      servicestubs.IntNumber> getGetEvenNumbersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getEvenNumbers",
      requestType = servicestubs.IntNumber.class,
      responseType = servicestubs.IntNumber.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<servicestubs.IntNumber,
      servicestubs.IntNumber> getGetEvenNumbersMethod() {
    io.grpc.MethodDescriptor<servicestubs.IntNumber, servicestubs.IntNumber> getGetEvenNumbersMethod;
    if ((getGetEvenNumbersMethod = ServiceGrpc.getGetEvenNumbersMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getGetEvenNumbersMethod = ServiceGrpc.getGetEvenNumbersMethod) == null) {
          ServiceGrpc.getGetEvenNumbersMethod = getGetEvenNumbersMethod =
              io.grpc.MethodDescriptor.<servicestubs.IntNumber, servicestubs.IntNumber>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getEvenNumbers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servicestubs.IntNumber.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servicestubs.IntNumber.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("getEvenNumbers"))
              .build();
        }
      }
    }
    return getGetEvenNumbersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<servicestubs.IntNumber,
      servicestubs.IntNumber> getAddSeqOfNumbersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addSeqOfNumbers",
      requestType = servicestubs.IntNumber.class,
      responseType = servicestubs.IntNumber.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<servicestubs.IntNumber,
      servicestubs.IntNumber> getAddSeqOfNumbersMethod() {
    io.grpc.MethodDescriptor<servicestubs.IntNumber, servicestubs.IntNumber> getAddSeqOfNumbersMethod;
    if ((getAddSeqOfNumbersMethod = ServiceGrpc.getAddSeqOfNumbersMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getAddSeqOfNumbersMethod = ServiceGrpc.getAddSeqOfNumbersMethod) == null) {
          ServiceGrpc.getAddSeqOfNumbersMethod = getAddSeqOfNumbersMethod =
              io.grpc.MethodDescriptor.<servicestubs.IntNumber, servicestubs.IntNumber>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addSeqOfNumbers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servicestubs.IntNumber.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servicestubs.IntNumber.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("addSeqOfNumbers"))
              .build();
        }
      }
    }
    return getAddSeqOfNumbersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<servicestubs.AddOperands,
      servicestubs.AddResult> getMultipleAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "multipleAdd",
      requestType = servicestubs.AddOperands.class,
      responseType = servicestubs.AddResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<servicestubs.AddOperands,
      servicestubs.AddResult> getMultipleAddMethod() {
    io.grpc.MethodDescriptor<servicestubs.AddOperands, servicestubs.AddResult> getMultipleAddMethod;
    if ((getMultipleAddMethod = ServiceGrpc.getMultipleAddMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getMultipleAddMethod = ServiceGrpc.getMultipleAddMethod) == null) {
          ServiceGrpc.getMultipleAddMethod = getMultipleAddMethod =
              io.grpc.MethodDescriptor.<servicestubs.AddOperands, servicestubs.AddResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "multipleAdd"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servicestubs.AddOperands.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servicestubs.AddResult.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("multipleAdd"))
              .build();
        }
      }
    }
    return getMultipleAddMethod;
  }

  private static volatile io.grpc.MethodDescriptor<servicestubs.IntervalNumbers,
      servicestubs.IntNumber> getFindPrimesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findPrimes",
      requestType = servicestubs.IntervalNumbers.class,
      responseType = servicestubs.IntNumber.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<servicestubs.IntervalNumbers,
      servicestubs.IntNumber> getFindPrimesMethod() {
    io.grpc.MethodDescriptor<servicestubs.IntervalNumbers, servicestubs.IntNumber> getFindPrimesMethod;
    if ((getFindPrimesMethod = ServiceGrpc.getFindPrimesMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getFindPrimesMethod = ServiceGrpc.getFindPrimesMethod) == null) {
          ServiceGrpc.getFindPrimesMethod = getFindPrimesMethod =
              io.grpc.MethodDescriptor.<servicestubs.IntervalNumbers, servicestubs.IntNumber>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "findPrimes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servicestubs.IntervalNumbers.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servicestubs.IntNumber.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("findPrimes"))
              .build();
        }
      }
    }
    return getFindPrimesMethod;
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
     * <pre>
     * ping server for testing service availability
     * </pre>
     */
    default void isAlive(servicestubs.ProtoVoid request,
        io.grpc.stub.StreamObserver<servicestubs.TextMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getIsAliveMethod(), responseObserver);
    }

    /**
     * <pre>
     * get first N even numbers 2,...,K
     * </pre>
     */
    default void getEvenNumbers(servicestubs.IntNumber request,
        io.grpc.stub.StreamObserver<servicestubs.IntNumber> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEvenNumbersMethod(), responseObserver);
    }

    /**
     * <pre>
     * add a sequence of numbers, ex: 1,2,10,5 = 18
     * </pre>
     */
    default io.grpc.stub.StreamObserver<servicestubs.IntNumber> addSeqOfNumbers(
        io.grpc.stub.StreamObserver<servicestubs.IntNumber> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getAddSeqOfNumbersMethod(), responseObserver);
    }

    /**
     * <pre>
     * multiple add operations using a bidirectional stream
     * </pre>
     */
    default io.grpc.stub.StreamObserver<servicestubs.AddOperands> multipleAdd(
        io.grpc.stub.StreamObserver<servicestubs.AddResult> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getMultipleAddMethod(), responseObserver);
    }

    /**
     * <pre>
     * find prime numbers in a given interval
     * </pre>
     */
    default void findPrimes(servicestubs.IntervalNumbers request,
        io.grpc.stub.StreamObserver<servicestubs.IntNumber> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindPrimesMethod(), responseObserver);
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
     * <pre>
     * ping server for testing service availability
     * </pre>
     */
    public void isAlive(servicestubs.ProtoVoid request,
        io.grpc.stub.StreamObserver<servicestubs.TextMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIsAliveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * get first N even numbers 2,...,K
     * </pre>
     */
    public void getEvenNumbers(servicestubs.IntNumber request,
        io.grpc.stub.StreamObserver<servicestubs.IntNumber> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetEvenNumbersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * add a sequence of numbers, ex: 1,2,10,5 = 18
     * </pre>
     */
    public io.grpc.stub.StreamObserver<servicestubs.IntNumber> addSeqOfNumbers(
        io.grpc.stub.StreamObserver<servicestubs.IntNumber> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getAddSeqOfNumbersMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * multiple add operations using a bidirectional stream
     * </pre>
     */
    public io.grpc.stub.StreamObserver<servicestubs.AddOperands> multipleAdd(
        io.grpc.stub.StreamObserver<servicestubs.AddResult> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getMultipleAddMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * find prime numbers in a given interval
     * </pre>
     */
    public void findPrimes(servicestubs.IntervalNumbers request,
        io.grpc.stub.StreamObserver<servicestubs.IntNumber> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getFindPrimesMethod(), getCallOptions()), request, responseObserver);
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
     * <pre>
     * ping server for testing service availability
     * </pre>
     */
    public servicestubs.TextMessage isAlive(servicestubs.ProtoVoid request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIsAliveMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * get first N even numbers 2,...,K
     * </pre>
     */
    public java.util.Iterator<servicestubs.IntNumber> getEvenNumbers(
        servicestubs.IntNumber request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetEvenNumbersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * find prime numbers in a given interval
     * </pre>
     */
    public java.util.Iterator<servicestubs.IntNumber> findPrimes(
        servicestubs.IntervalNumbers request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getFindPrimesMethod(), getCallOptions(), request);
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
     * <pre>
     * ping server for testing service availability
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<servicestubs.TextMessage> isAlive(
        servicestubs.ProtoVoid request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIsAliveMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_IS_ALIVE = 0;
  private static final int METHODID_GET_EVEN_NUMBERS = 1;
  private static final int METHODID_FIND_PRIMES = 2;
  private static final int METHODID_ADD_SEQ_OF_NUMBERS = 3;
  private static final int METHODID_MULTIPLE_ADD = 4;

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
        case METHODID_IS_ALIVE:
          serviceImpl.isAlive((servicestubs.ProtoVoid) request,
              (io.grpc.stub.StreamObserver<servicestubs.TextMessage>) responseObserver);
          break;
        case METHODID_GET_EVEN_NUMBERS:
          serviceImpl.getEvenNumbers((servicestubs.IntNumber) request,
              (io.grpc.stub.StreamObserver<servicestubs.IntNumber>) responseObserver);
          break;
        case METHODID_FIND_PRIMES:
          serviceImpl.findPrimes((servicestubs.IntervalNumbers) request,
              (io.grpc.stub.StreamObserver<servicestubs.IntNumber>) responseObserver);
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
        case METHODID_ADD_SEQ_OF_NUMBERS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.addSeqOfNumbers(
              (io.grpc.stub.StreamObserver<servicestubs.IntNumber>) responseObserver);
        case METHODID_MULTIPLE_ADD:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.multipleAdd(
              (io.grpc.stub.StreamObserver<servicestubs.AddResult>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getIsAliveMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              servicestubs.ProtoVoid,
              servicestubs.TextMessage>(
                service, METHODID_IS_ALIVE)))
        .addMethod(
          getGetEvenNumbersMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              servicestubs.IntNumber,
              servicestubs.IntNumber>(
                service, METHODID_GET_EVEN_NUMBERS)))
        .addMethod(
          getAddSeqOfNumbersMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              servicestubs.IntNumber,
              servicestubs.IntNumber>(
                service, METHODID_ADD_SEQ_OF_NUMBERS)))
        .addMethod(
          getMultipleAddMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              servicestubs.AddOperands,
              servicestubs.AddResult>(
                service, METHODID_MULTIPLE_ADD)))
        .addMethod(
          getFindPrimesMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              servicestubs.IntervalNumbers,
              servicestubs.IntNumber>(
                service, METHODID_FIND_PRIMES)))
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
              .addMethod(getIsAliveMethod())
              .addMethod(getGetEvenNumbersMethod())
              .addMethod(getAddSeqOfNumbersMethod())
              .addMethod(getMultipleAddMethod())
              .addMethod(getFindPrimesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
