package pl.jsystems.szkolenie.szkolenieApi.service;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pl.jsystems.szkolenie.szkolenieApi.model.AzureUser;
import pl.jsystems.szkolenie.szkolenieApi.specification.Specification;

import java.util.List;

public class AzureServiceByPawel {
    private static final String AUTHORS = "/Authors";

    public static List<AzureUser> getAzureAuthors() {
        return getAuthorsUnPack(AUTHORS).getList("", AzureUser.class);
    }

    private static JsonPath getAuthorsUnPack(String path) {
        return getAzureAuthors(path).then().extract().body().jsonPath();
    }

    private static Response getAzureAuthors(String path) {
        return getAzureSpec()
                .get(path)
                .andReturn();
    }

    private static RequestSpecification getAzureSpec() {
        return RestAssured
                .given()
                .spec(Specification.azureSpecification());
    }
}
