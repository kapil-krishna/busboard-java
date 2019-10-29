package training.busboard;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.transform.Source;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Bus Stop finder! Input your postcode to find out the next 5 buses" +
                        " arriving at your two nearest stops!");
        String postCode = input.nextLine();

        Pattern pattern = Pattern.compile("([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9][A-Za-z]?))))\\s?[0-9][A-Za-z]{2})");
        Matcher matcher = pattern.matcher(postCode);

        while(!(matcher.matches())) {
            Scanner repeat = new Scanner(System.in);
            System.out.println("I'll need a valid postcode to work my magic.");
            postCode = repeat.nextLine();
        }

        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        Result pc = client.target("" +
                "http://api.postcodes.io/postcodes/" + postCode)
                .request(MediaType.APPLICATION_JSON)
                .get(Result.class);

        System.out.println(pc.getResult().getLongitude());
        System.out.println(pc.getResult().getLatitude());


//
//        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
//        List<Bus> busList = client.target("" +
//                "https://api.tfl.gov.uk/StopPoint/" + postCode + "/Arrivals?app_id=da4a2af3&app_key=98ba2b65d63f9c812a52c6c095eced7a")
//                .request(MediaType.APPLICATION_JSON)
//                .get(new GenericType<List<Bus>>() {});
//
//        System.out.println("|Line |Destination              |Arriving in... |Arrival time        |" +
//        "\n----------------------------------------------------------------------");
//
//        for (int i = 1; i <= 5 && i < (busList.size()); i++) {
//            System.out.println(busList.get(i));
//        }
//
//      System.out.println(busList);
    }
}
