package training.busboard;

import java.util.List;

public class Main {
    public static void main(String args[]) {

        //ask user for postcode
        String postCode = RequestPostcode.RequestPostcode();

        //use postcode to get lon and lat of area
        PCResult pc = API_PC.getLonLat(postCode);

        //use lon/lat to get naptan
        TFLResult listOfStopPoints = API_TFL.getNaptan(pc.getResult().getLatitude(), pc.getResult().getLongitude());

        //use stopPoints to get list of busStops
        BusStopList busStopList = BusStopList.BusStopList(listOfStopPoints);

        //iterate on naptans and print each BusList
//        for (int i = 0; i <= 1 && i < listOfStopPoints.getStopPoints().size(); i++) {
//            String ID = listOfStopPoints.getStopPoints().get(i).getNaptanId();
//            List<BusStop> busStopList = API_TFL.getBusList(ID);
//            if (i > 0) {
//                System.out.println("\n");
//            }
//            System.out.println("STATION: " + busList.get(0).getStationName() + "     " + "STOP: " + listOfStopPoints.getStopPoints().get(i).getIndicator() +
//                    "\n---------------------------------------------------------------------------");
//            System.out.println("|Line |Destination                   |Arriving in... |Arrival time        |" +
//                    "\n---------------------------------------------------------------------------");
//            for (int j = 1; j <= 5 && j < (busList.size()); j++) {
//                System.out.println(String.format("|%-5s|%-30s|%-15d|%-20s|",
//                        busList.get(j).getLineName(),
//                        busList.get(j).getDestinationName(),
//                        busList.get(j).getTimeToStation(),
//                        busList.get(j).getExpectedArrival()));
//            }
//            System.out.println("---------------------------------------------------------------------------");
//        }

    }
}
