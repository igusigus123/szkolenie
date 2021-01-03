package pl.jsystems.szkolenie.szkolenieApi.service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pl.jsystems.szkolenie.szkolenieApi.configuration.ApiConfig;
import pl.jsystems.szkolenie.szkolenieApi.specification.Specification;

public class Service {

//    public static Response returnResponse (String host) {
//        return RestAssured
//                .given()
//                .get(host)
//                .andReturn();
//    }
//
//    public static JsonPath returnResponseUnpack (String host) {
//        return returnResponse(host).then().extract().body().jsonPath();
//    }
public static Response returnResponse(String host) {
    return RestAssured
            .given()
            .get(host)
            .andReturn();
}

    public static JsonPath returnResponseUnPack(String host) {
        return returnResponse(host).then().extract().body().jsonPath();
    }

}
