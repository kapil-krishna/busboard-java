package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)

public class Result {
    Double status;
    Postcode result;

    public Double getStatus() {
        return status;
    }

    public Postcode getResult() {
        return result;
    }
}

