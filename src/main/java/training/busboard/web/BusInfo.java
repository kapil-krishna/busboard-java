package training.busboard.web;

import training.busboard.*;

import java.util.List;

public class BusInfo {
    private final String postcode;
//    private final PCResult pc;
//    private final TFLResult listOfStopPoints;
//    private final List<Bus> firstList;
//    private final String firstStation;
//    private final String firstStop;
//    private final List<Bus> secondList;
//    private final String secondStation;
//    private final String secondStop;

    public BusInfo(String postcode) {

        this.postcode = postcode;
//        this.pc = API_PC.getLonLat(postcode);
//        this.listOfStopPoints = API_TFL.getNaptan(pc.getResult().getLatitude(), pc.getResult().getLongitude());
//        this.firstList = API_TFL.getBusList(listOfStopPoints.getStopPoints().get(0).getNaptanId());
//        this.firstStation = firstList.get(0).getStationName();
//        this.firstStop = listOfStopPoints.getStopPoints().get(0).getIndicator();
//        this.secondList = API_TFL.getBusList(listOfStopPoints.getStopPoints().get(1).getNaptanId());
//        this.secondStation = secondList.get(0).getStationName();
//        this.secondStop = listOfStopPoints.getStopPoints().get(1).getIndicator();
    }

    public String getPostcode() {
        return postcode;
    }

//    public PCResult getPc() {
//        return pc;
//    }
//
//    public TFLResult getListOfStopPoints() {
//        return listOfStopPoints;
//    }
//
//    public List<Bus> getFirstList() {
//        return firstList;
//    }
//
//    public String getFirstStation() {
//        return firstStation;
//    }
//
//    public String getFirstStop() {
//        return firstStop;
//    }
//
//    public List<Bus> getSecondList() {
//        return secondList;
//    }
//
//    public String getSecondStation() {
//        return secondStation;
//    }
//
//    public String getSecondStop() {
//        return secondStop;
//    }
}
