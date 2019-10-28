package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)

public class Bus {
    private String id;
    private String lineName;
    private String destinationName;
    private Integer timeToStation;
    private String expectedArrival;

    @Override
    public String toString () {
        String print = String.format("|%-5s|%-25s|%-15d|%-20s", lineName, destinationName, timeToStation, expectedArrival);
        return print;
    }

    public String getId() {
        return id;
    }
    public String getLineName() {
        return lineName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public Integer getTimeToStation() {
        return timeToStation;
    }

    public String getExpectedArrival() {
        return expectedArrival;
    }
}
