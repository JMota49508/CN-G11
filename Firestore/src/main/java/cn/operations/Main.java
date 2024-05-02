package cn.operations;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import static com.google.cloud.firestore.Filter.equalTo;

public class Main {

    private static String path =
            "C:\\Users\\voyst\\OneDrive\\Ambiente de Trabalho\\things\\escola\\2 Semestre\\CN\\LABS\\Firestore\\src\\" +
                    "main\\java\\cn\\operations\\OcupacaoEspacosPublicos.csv";

    public static void main(String[] args) throws Exception {
        // Com variável GOOGLE_APPLICATION_CREDENTIALS
        GoogleCredentials credentials =
                GoogleCredentials.getApplicationDefault();
        FirestoreOptions options = FirestoreOptions
                .newBuilder().setDatabaseId("db-name").setCredentials(credentials)
                .build();
        Firestore db = options.getService();
        boolean end = false;
        while (!end) {
            try {
                int option = Menu();
                switch (option) {
                    case 1:
                        insertDocuments(path, db, "ocupa-espacos");
                        break;
                    case 2:
                        getDocumentById(db);
                        System.out.println();
                    case 3:
                        deleteDocumentField(db);
                        System.out.println();
                    case 4:
                        getDocumentByParish(db);
                        System.out.println();
                    case 5:
                        getDocumentWithSpecificFields(db);
                        System.out.println();
                    case 6:
                        getDocumentsStartedInFebruary(db);
                        System.out.println();
                    case 7:
                        getDocumentsFromFebruary();
                        System.out.println();
                    case 0:
                        end = true;
                }
            } catch (Exception ex) {
                System.out.println("Execution call Error  !");
                ex.printStackTrace();
            }
        }
    }



    public static OcupacaoTemporaria convertLineToObject(String line) throws ParseException {
        String[] cols = line.split(",");
        OcupacaoTemporaria ocup = new OcupacaoTemporaria();
        ocup.ID = Integer.parseInt(cols[0]);
        ocup.location = new Localizacao();
        ocup.location.point = new GeoPoint(Double.parseDouble(cols[1]), Double.parseDouble(cols[2]));
        ocup.location.coord = new Coordenadas();
        ocup.location.coord.X = Double.parseDouble(cols[1]);
        ocup.location.coord.Y = Double.parseDouble(cols[2]);
        ocup.location.freguesia = cols[3];
        ocup.location.local = cols[4];
        ocup.event = new Evento();
        ocup.event.evtID = Integer.parseInt(cols[5]);
        ocup.event.nome = cols[6];
        ocup.event.tipo = cols[7];
        ocup.event.details = new HashMap<String, String>();
        if (!cols[8].isEmpty()) ocup.event.details.put("Participantes", cols[8]);
        if (!cols[9].isEmpty()) ocup.event.details.put("Custo", cols[9]);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        ocup.event.dtInicio = formatter.parse(cols[10]);
        ocup.event.dtFinal = formatter.parse(cols[11]);
        ocup.event.licenciamento = new Licenciamento();
        ocup.event.licenciamento.code = cols[12];
        ocup.event.licenciamento.dtLicenc = formatter.parse(cols[13]);
        return ocup;
    }

    public static void insertDocuments(String pathnameCSV, Firestore db, String collectionName)
            throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(pathnameCSV));
        CollectionReference colRef = db.collection(collectionName);
        String line;
        while ((line = reader.readLine()) != null) {
            OcupacaoTemporaria ocup = convertLineToObject(line);
            DocumentReference docRef = colRef.document("Lab4-" + ocup.ID);
            ApiFuture<WriteResult> resultFut = docRef.set(ocup);
            WriteResult result = resultFut.get();
            System.out.println("Update time : " + result.getUpdateTime());
        }
    }

    private static int Menu() {
        int op;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("    MENU");
            System.out.println(" 1 - Insert documents");
            System.out.println(" 2 - Get document by ID");
            System.out.println(" 3 - Delete a document's field");
            System.out.println(" 4 - Get documents by parish");
            System.out.println(" 5 - Get all documents with specific fields");
            System.out.println(" 6 - Get all documents started in February");
            System.out.println(" 7 - Get all documents from February");
            System.out.println(" 0 - Exit");
            System.out.println();
            System.out.println("Choose an Option?");
            op = scan.nextInt();
        } while (!((op >= 0 && op <= 2)));
        return op;
    }

    private static String read(String msg, Scanner input) {
        System.out.print(msg);
        return input.nextLine();
    }


    public static void getDocumentById(Firestore db) throws ExecutionException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        String id = scan.nextLine();
        DocumentReference docRef = db.collection("ocupa-espacos").document(id);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        OcupacaoTemporaria ocup = document.toObject(OcupacaoTemporaria.class);
        printOcupation(ocup);
    }

    public static void getDocumentByParish(Firestore db) throws ExecutionException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        String parish = scan.nextLine();
        Query query = db.collection("ocupa-espacos").whereEqualTo("location.freguesia", parish);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        System.out.println("Ocupations that are in the parish " + parish + " are:");
        for (DocumentSnapshot doc: querySnapshot.get().getDocuments()) {
            System.out.print("OcupID: " + doc.getId());
        }
    }

    public static void deleteDocumentField(Firestore db) throws ExecutionException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the document ID: ");
        String id = scan.nextLine();
        System.out.print("Enter the field to delete: ");
        String field = scan.nextLine();
        DocumentReference docRef = db.document("ocupa-espacos/" + id);
        Map<String, Object> updates = new HashMap<>();
        updates.put(field, FieldValue.delete());
        ApiFuture<WriteResult> writeResult = docRef.update(updates);
        System.out.println("Update time : " + writeResult.get());
    }

    public static void getDocumentsFromFebruary(Firestore db) throws ExecutionException, InterruptedException {
        Query query = db.collection("ocupa-espacos")
                .whereGreaterThan("event.dtInicio", "2017-01-31")
                .whereLessThan("event.dtFinal", "2017-03-01");
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        System.out.println("Ocupations that were started and finished in February:");
        for (DocumentSnapshot doc: querySnapshot.get().getDocuments()) {
            System.out.print("OcupID: " + doc.getId());
        }
    }

    public static void getDocumentsStartedInFebruary(Firestore db) throws ExecutionException, InterruptedException {
        Query query = db.collection("ocupa-espacos")
                .whereGreaterThan("event.dtInicio", "2017-01-31")
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        System.out.println("Ocupations that were started in February:");
        for (DocumentSnapshot doc: querySnapshot.get().getDocuments()) {
            System.out.print("OcupId: " + doc.getId());
        }
    }

    public static void getDocumentWithSpecificFields(Firestore db) throws ExecutionException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the value you want the Id to be greater than: ");
        int id = scan.nextInt();
        System.out.println("Enter the Parish name: ");
        String parish = scan.nextLine();
        System.out.println("Enter the event type: ");
        String event = scan.nextLine();
        Query query = db.collection("ocupa-espacos")
                .whereGreaterThan("ID", id)
                .whereEqualTo("location.freguesia", parish)
                .whereEqualTo("event.tipo", event);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        System.out.println("Ocupations that fit the criteria:");
        for (DocumentSnapshot doc: querySnapshot.get().getDocuments()) {
            System.out.print("OcupID: " + doc.getId());
        }
    }

    private static void printOcupation(OcupacaoTemporaria ocup) {
        System.out.println("ID: " + ocup.ID);
        System.out.println("Event: ");
        System.out.println("\tId: " + ocup.event.evtID);
        System.out.println("\tName: " + ocup.event.nome);
        System.out.println("\tType: " + ocup.event.tipo);
        System.out.println("\tDetails: " + ocup.event.details);
        System.out.println("\tStart Date: " + ocup.event.dtInicio);
        System.out.println("\tFinal Date: " + ocup.event.dtFinal);
        System.out.println("\tLicense: ");
        System.out.println("\t\tCode: " + ocup.event.licenciamento.code);
        System.out.println("\t\tDate: " + ocup.event.licenciamento.dtLicenc);
        System.out.println("Location: ");
        System.out.println("\tCoords: " + ocup.location.coord);
        System.out.println("\t\tX: " + ocup.location.coord.X);
        System.out.println("\t\tY: " + ocup.location.coord.Y);
        System.out.println("\tParish: " + ocup.location.freguesia);
        System.out.println("\tPlace: " + ocup.location.local);
        System.out.println("\tPoint: " + ocup.location.point);
    }
}
