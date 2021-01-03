package pl.jsystems.szkolenie.szkolenieApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceModel {
    @JsonProperty(required = true)
    public String produce;
    @JsonProperty(value = "screen.size", required = true)
    public double screenSize;

    @Override
    public String toString() {
        return "DeviceModel{" +
                "produce='" + produce + '\'' +
                ", screenSize=" + screenSize +
                '}';
    }
}
