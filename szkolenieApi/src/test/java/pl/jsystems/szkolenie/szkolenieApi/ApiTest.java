package pl.jsystems.szkolenie.szkolenieApi;

import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

@DisplayName("ApiTest")
public class ApiTest {

    @DisplayName("First api test to mocky.io")
    @Test
    public void firstApiTest(){
        RestAssured
                .given()
                .get("https://run.mocky.io/v3/d3b0627f-997c-4cdb-a862-7258329db88d")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Jan"))
                .body("surname", equalTo("Kowalski"));
    }

    @DisplayName("User with devices test")
    @Test
    public void userDevices(){
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].imie", notNullValue())
                .body("[0].imie", equalTo("Piotr"))
                .body("[0].nazwisko", notNullValue())
                .body("[0].nazwisko", equalTo("Kowalski"))
                .body("[0].device[0].type", notNullValue())
                .body("[0].device[0].type", equalTo("computer"))
                .body("[0].device[0].device.model[0].produce", equalTo("dell"));

    }
    @DisplayName("User with devices by model")
    @Test
    public void userDeviceByModel (){
        List<User> users = RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("", User.class);
        System.out.println(users.toString());
        assertThat(users.get(0).imie).isEqualTo("Piotr");
    }


}
