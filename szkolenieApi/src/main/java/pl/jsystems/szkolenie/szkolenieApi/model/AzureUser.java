package pl.jsystems.szkolenie.szkolenieApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AzureUser {
    @JsonProperty(required = true)
    public long id;
    @JsonProperty(required = true)
    public long idBook;
    @JsonProperty(required = true)
    public String firstName;
    @JsonProperty(required = true)
    public String lastName;

    @Override
    public String toString() {
        return "AzureUser{" +
                "id=" + id +
                ", idBook=" + idBook +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
