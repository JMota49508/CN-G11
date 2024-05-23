import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.pubsub.v1.ProjectSubscriptionName;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class LabelsApp {
    private static String svcIP = "localhost";

    private static int svcPort = 8000;

    private static ManagedChannel channel;

    static String PROJECT_ID;

    static String TOPIC_ID;

    static String SUBSCRIPTION_ID;

    public static void main(String[] args) throws InterruptedException {
        channel = ManagedChannelBuilder.forAddress(svcIP, svcPort).usePlaintext().build();

        if (args.length > 0) {
            PROJECT_ID = args[0];
            TOPIC_ID = args[1];
            SUBSCRIPTION_ID = args[2];
        } else {
            System.out.println("Usage: LabelsApp <project_id> <topic_id> <subscription_id>");
            System.exit(-1);
        }
        Subscriber subscriber = subscribeMessages();
        while (true) {
            Thread.sleep(1000);
        }
    }

    public static Subscriber subscribeMessages() {
        ProjectSubscriptionName projectSubscriptionName = ProjectSubscriptionName.of(PROJECT_ID, SUBSCRIPTION_ID);
        ExecutorProvider executorProvider = InstantiatingExecutorProvider
                .newBuilder()
                .setExecutorThreadCount(1)
                .build();
        Subscriber subscriber = Subscriber.newBuilder(projectSubscriptionName, new MessageReceiverHandler())
                .setExecutorProvider(executorProvider)
                .build();
        subscriber.startAsync().awaitRunning();
        return subscriber;
    }
}