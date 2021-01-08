package pl.jsystems.szkolenie.szkolenieApi.service;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pl.jsystems.szkolenie.szkolenieApi.model.AzureUser;

import java.util.List;

public class AzureService {
    private static final String host = "http://fakerestapi.azurewebsites.net/api/v1/Authors";
    public static Response returnUserResponse(){

        return returnResponseGetV2();
    }
    public static List<AzureUser> getUsers() {

        return returnResponseGetV2Unpack().getList("", AzureUser.class);
    }

    public static JsonPath returnResponseGetV2Unpack () {
        return returnResponseGetV2().then().extract().body().jsonPath();
    }
    public static Response returnResponseGetV2 () {
        return RestAssured
                .given()
                .get(host)
                .andReturn();
    }

}
