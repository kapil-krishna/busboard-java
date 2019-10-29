package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)

public class Postcode {
    private String postcode;
    private Double longitude;
    private Double latitude;

//    @Override
//    public String toString () {
//        String print = String.format("|%-8s|%-10d|%-15d|%-20s", postcode, longitude, latitude);
//        return print;
//    }

    public String getPostcode() {
        return postcode;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }
}
