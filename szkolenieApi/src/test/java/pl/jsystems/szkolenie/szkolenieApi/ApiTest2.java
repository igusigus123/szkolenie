package pl.jsystems.szkolenie.szkolenieApi;

import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import static org.hamcrest.Matchers.equalTo;

@Tag("API")
@DisplayName("ApiTest2")
public class ApiTest2 {
    @DisplayName("First api test to mocky.io")
    @Test
    public void firstApiTest() {
        RestAssured
                .given()
                .get("https://run.mocky.io/v3/d3b0627f-997c-4cdb-a862-7258329db88d")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Jan"))
                .body("surname", equalTo("Kowalski"));
    }
}
