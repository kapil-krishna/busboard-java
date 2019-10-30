package training.busboard;

import java.util.List;

public class PrintBusList {

    public static void printBusList(TFLResult naptan) {
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
