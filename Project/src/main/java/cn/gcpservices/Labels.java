package cn.gcpservices;

import com.google.cloud.vision.v1.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Labels {
    public static List<String> detectLabels(String gsURI) throws IOException {
        List<AnnotateImageRequest> requests = new ArrayList<>();
        List<String> labels = new ArrayList<>();

        // Obtém imagem diretamente de um ficheiro: para testes locais
        // ByteString imgBytes = ByteString.readFrom(new FileInputStream("cat.jpg"));
        //Image img = Image.newBuilder().setContent(imgBytes).build();
        // Obtém imagem diretamente do serviço Storage usando um gs URI (gs://...) para o Blob com imagem
        Image img = Image.newBuilder()
                .setSource(ImageSource.newBuilder().setImageUri(gsURI).build())
                .build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.LABEL_DETECTION).build();
        AnnotateImageRequest request =
                AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);
        // Initialize client that will be used to send requests. This client only needs to be created
        // once, and can be reused for multiple requests. After completing all of your requests, call
        // the "close" method on the client to safely clean up any remaining background resources.
        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();
            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.format("Error: %s%n", res.getError().getMessage());
                } else {
                    // For full list of available annotations, see http://g.co/cloud/vision/docs
                    for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
                        labels.add(annotation.getDescription().toLowerCase());
//                        annotation.getAllFields()
//                                .forEach((k, v) -> System.out.format("%s : %s%n", k, v.toString()));
                    }
                }
            }
        }
        return labels;
    }
}
