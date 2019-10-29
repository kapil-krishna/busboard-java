package training.busboard;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.transform.Source;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String args[]) {

        //ask user for postcode
        String postCode = RequestPostcode.RequestPostcode();

        //use postcode to get lon and lat of area
        PCResult pc = API_PC.getLonLat(postCode);

        //use lon/lat to get naptan
        TFLResult naptan = API_TFL.getNaptan(pc.getResult().getLatitude(), pc.getResult().getLongitude());

        //iterate of list of naptan(s) to get a list of buses
        for (int i = 0; i <= 1 && i < naptan.getStopPoints().size(); i++) {
            String ID = naptan.getStopPoints().get(i).getNaptanId();
            List<Bus> busList = API_TFL.getBusList(ID);
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
