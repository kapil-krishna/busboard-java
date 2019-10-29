package training.busboard;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class API_PC {

    public static PCResult getLonLat(String postCode) {
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        PCResult pc = client
                .target("http://api.postcodes.io/postcodes/")
                .path(postCode)
                .request(MediaType.APPLICATION_JSON)
                .get(PCResult.class);
        return pc;
    }
}
