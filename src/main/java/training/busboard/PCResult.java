package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)

public class PCResult {
    private Double status;
    private Postcode result;

    public Double getStatus() {
        return status;
    }

    public Postcode getResult() {
        return result;
    }
}

