package pl.jsystems.szkolenie.szkolenieApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleUser {
    @JsonProperty(required = true)
    String name;
    @JsonProperty(required = true)
    String surname;

    public SimpleUser(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public SimpleUser() {
    }

    @Override
    public String toString() {
        return "SimpleUser{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
