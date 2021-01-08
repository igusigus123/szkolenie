package pl.jsystems.szkolenie.szkolenieApi.model.error;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SingleError {

    @JsonProperty("error.code")
    public int errorCode;

    @JsonProperty("validation_erro")
    public String validationError;

    public String message;
}
