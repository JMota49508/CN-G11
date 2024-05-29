package functionhttp;

import com.google.cloud.compute.v1.Instance;
import com.google.cloud.compute.v1.InstancesClient;
import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Entrypoint implements HttpFunction {

    private static final Logger logger = Logger.getLogger(Entrypoint.class.getName());

    @Override
    public void service(HttpRequest request, HttpResponse response) throws Exception {
        logger.info("Inside Function");
        BufferedWriter writer = response.getWriter();
        String gcpProjectID = "cn2324-t1-g11";
        String zone = "europe-west2-c";
        String instGroup = "grpc-server-group";
        logger.info("Before Pulling");
        ArrayList<String> ipAddresses = new ArrayList<>();
        try (InstancesClient client = InstancesClient.create()) {
            for (Instance instance : client.list(gcpProjectID, zone).iterateAll()) {
                if (instance.getStatus().compareTo("RUNNING") == 0) {
                    logger.info("inside RUNNING");
                    if (instance.getName().contains(instGroup)) {
                        String ip = instance.getNetworkInterfaces(0).getAccessConfigs(0).getNatIP();
                        logger.info("IP: " + ip);
                        ipAddresses.add(ip);
                    }
                }
            }
        }
        writer.write(new Gson().toJson(ipAddresses.toArray()));
        writer.close();
    }
}
