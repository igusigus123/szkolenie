package pl.jsystems.szkolenie.szkolenieApi.Service;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Service {
    public Response returnResponse (String host) {
        return RestAssured
                .given()
                .get(host)
                .andReturn();

        //http://www.mocky.io/v2/5a6a58222e0000d0377a7789
    }
}
