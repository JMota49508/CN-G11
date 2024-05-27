import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.pubsub.v1.PubsubMessage;
import grpcserverapp.File;
import grpcserverapp.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MessageReceiverHandler implements MessageReceiver {
    GoogleCredentials credentials;

    {
        try {
            credentials = GoogleCredentials.getApplicationDefault();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    FirestoreOptions firestoreOptions = FirestoreOptions
            .newBuilder().setDatabaseId("image-storage").setCredentials(credentials)
            .build();
    Firestore db = firestoreOptions.getService();

    @Override
    public void receiveMessage(PubsubMessage pubsubMessage, AckReplyConsumer ackReplyConsumer) {
        try {
            System.out.println("Message (Id:" + pubsubMessage.getMessageId() + " Data:" + pubsubMessage.getData().toStringUtf8() + ")");
            Map<String, String> attributes = pubsubMessage.getAttributesMap();
            for (String key : attributes.keySet())
                System.out.println("Msg Attribute:(" + key + ", " + attributes.get(key) + ")");
            ackReplyConsumer.ack();
            String fileName = attributes.get("fileName");

            Date creationDate = Service.getCurrentDate();
            String entry = "File " + fileName + " was submitted on " + creationDate.toString();
            LogEntry logEntry = new LogEntry(entry);
            DocumentReference docRef = db.collection("logs").document(UUID.randomUUID().toString());
            docRef.set(logEntry);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
