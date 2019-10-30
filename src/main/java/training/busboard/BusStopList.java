package training.busboard;

import java.util.ArrayList;
import java.util.List;

public class BusStopList {
    private List<BusStop> busStopList;


    public BusStopList(TFLResult listOfStopPoints) {
        this.busStopList = new ArrayList<>();
        for (int i = 0; i <= 1 && i < listOfStopPoints.getStopPoints().size(); i++) {
            StopPoint stopPoint = listOfStopPoints.getStopPoints().get(i);
            BusStop busStop = new BusStop(stopPoint);
            busStopList.add(busStop);
        }
    }

    public List<BusStop> getBusStopList() {
        return busStopList;
    }
}
