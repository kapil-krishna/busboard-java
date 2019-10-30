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

        //use naptan to get and print BusList
        PrintBusList.printBusList(naptan);

    }
}
