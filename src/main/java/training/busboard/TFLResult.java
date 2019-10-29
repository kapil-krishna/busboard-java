package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties (ignoreUnknown = true)

public class TFLResult {
    private List<StopPoint> stopPoints;

    public List<StopPoint> getStopPoints() {
        return stopPoints;
    }
}
