package grpcserverapp;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.compute.v1.InstanceGroupManagersClient;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.protobuf.Empty;
import scalabilitystubs.ResizeRequest;
import scalabilitystubs.ScalabilityServiceGrpc;
import io.grpc.stub.StreamObserver;
import java.io.IOException;

public class ScalabilityService extends ScalabilityServiceGrpc.ScalabilityServiceImplBase {

    public ScalabilityService() {}

    @Override
    public void resizeInstance(ResizeRequest request, StreamObserver<Empty> responseObserver) {
        try {
            System.out.println("Resizing instance group ... ");
            InstanceGroupManagersClient managersClient = InstanceGroupManagersClient.create();
            OperationFuture<Operation, Operation> result = managersClient.resizeAsync(
                    request.getProjectId(),
                    request.getZone(),
                    request.getInstanceGroup(),
                    request.getSize()
            );
            Operation oper = result.get();
            System.out.println("Resizing with status " + oper.getStatus());
            responseObserver.onNext(Empty.newBuilder().build());
            responseObserver.onCompleted();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
