package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)

public class StopPoint {
    private String naptanId;
    private String indicator;

    public String getNaptanId() {
        return naptanId;
    }

    public String getIndicator() {
        return indicator;
    }
}
