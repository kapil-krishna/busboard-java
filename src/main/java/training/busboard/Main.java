package training.busboard;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.transform.Source;
import java.util.Collections;
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

        while (!(matcher.matches())) {
            Scanner repeat = new Scanner(System.in);
            System.out.println("I'll need a valid postcode to work my magic.");
            postCode = repeat.nextLine();
        }

        //use postcode to get lon and lat of area
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        PCResult pc = client.target("" +
                "http://api.postcodes.io/postcodes/" + postCode)
                .request(MediaType.APPLICATION_JSON)
                .get(PCResult.class);

        //use lon and lat to get naptan code
        Client client2 = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        TFLResult naptan = client2.target("" +
                "https://api.tfl.gov.uk/StopPoint?stopTypes=NaptanPublicBusCoachTram&lat=" +
                pc.getResult().getLatitude() + "&lon=" + pc.getResult().getLongitude())
                .request(MediaType.APPLICATION_JSON)
                .get(TFLResult.class);

        //iterate of list of naptan(s) to get a list of buses
        for (int i = 0; i <= 1 && i < naptan.getStopPoints().size(); i++) {
            String ID = naptan.getStopPoints().get(i).getNaptanId();
            Client client3 = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
            List<Bus> busList = client3.target("" +
                    "https://api.tfl.gov.uk/StopPoint/" + ID + "/Arrivals?app_id=da4a2af3&app_key=98ba2b65d63f9c812a52c6c095eced7a")
                    .request(MediaType.APPLICATION_JSON)
                    .get(new GenericType<List<Bus>>() {});

            if (i > 0) {
                System.out.println("\n");
            }
            System.out.println("STATION: " + busList.get(0).getStationName() + "     " + "STOP: " + naptan.getStopPoints().get(i).getIndicator() +
                    "\n---------------------------------------------------------------------------");
            System.out.println("|Line |Destination                   |Arriving in... |Arrival time        |" +
                    "\n---------------------------------------------------------------------------");
            for (int j = 1; j <= 5 && j < (busList.size()); j++) {
                System.out.println(String.format("|%-5s|%-30s|%-15d|%-20s|",
                        busList.get(j).getLineName(),
                        busList.get(j).getDestinationName(),
                        busList.get(j).getTimeToStation(),
                        busList.get(j).getExpectedArrival()));
            }
            System.out.println("---------------------------------------------------------------------------");
        }
    }
}
