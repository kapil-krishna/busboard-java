package training.busboard.web;

import training.busboard.*;

public class BusInfo {
    private final String postcode;
    private final PCResult pc;
    private final TFLResult naptan;

    public BusInfo(String postcode) {

        this.postcode = postcode;
        this.pc = API_PC.getLonLat(postcode);
        this.naptan = API_TFL.getNaptan(pc.getResult().getLatitude(), pc.getResult().getLongitude());
    }

    public void getBusList() {
        PrintBusList.printBusList(naptan);
    }

    public String getPostcode() {
        return postcode;
    }
}
