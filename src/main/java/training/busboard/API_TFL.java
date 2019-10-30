package training.busboard;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.Comparator;
import java.util.List;

public class API_TFL {

    public static TFLResult getNaptan(Object latitude, Object longitude) {
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        TFLResult name = client
                .target("https://api.tfl.gov.uk")
                .path("StopPoint")
                .queryParam("stopTypes", "NaptanPublicBusCoachTram")
                .queryParam("lat", latitude)
                .queryParam("lon", longitude)
                .queryParam("app_id", "da4a2af3")
                .queryParam("app_key", "98ba2b65d63f9c812a52c6c095eced7a")
                .request(MediaType.APPLICATION_JSON)
                .get(TFLResult.class);
        return name;
    }

    public static List<Bus> getBusList(String naptanID) {
        Client client3 = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        List<Bus> busList = client3
                .target("https://api.tfl.gov.uk")
                .path("StopPoint/" + naptanID + "/Arrivals")
                .queryParam("app_id", "da4a2af3")
                .queryParam("app_key", "98ba2b65d63f9c812a52c6c095eced7a")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Bus>>() {});
        busList.sort(Comparator.comparing(Bus::getTimeToStation));
        return busList;
    }
}
