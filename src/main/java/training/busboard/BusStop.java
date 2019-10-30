package training.busboard;

import java.util.ArrayList;
import java.util.List;

public class BusStop {
    List<Bus> busListAtStop;
    String stationName;
    String stopCode;

    public BusStop (StopPoint stopPoint) {
        String ID = stopPoint.getNaptanId();
        this.busListAtStop = API_TFL.getBusList(ID);
        this.stationName = busListAtStop.get(0).getStationName();
        this.stopCode = stopPoint.getIndicator();
    }

//    public static List<BusStop> getBusStopList (TFLResult listOfStopPoints) {
//        List<BusStop> listOfBusStops = new ArrayList<>();
//        for (int i = 0; i <= 1 && i < listOfStopPoints.getStopPoints().size(); i++) {
//            BusStop busStop = BusStop(listOfStopPoints.getStopPoints().get(i));
//            listOfBusStops.add(busStop);
//        }
//        return listOfBusStops;
//    }

    public List<Bus> getBusList() {
        return busListAtStop;
    }

    public String getStationName() {
        return stationName;
    }

    public String getStopCode() {
        return stopCode;
    }
}
