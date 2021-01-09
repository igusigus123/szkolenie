package pl.jsystems.szkolenie.szkolenieApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import pl.jsystems.szkolenie.szkolenieApi.model.AzureUser;
import pl.jsystems.szkolenie.szkolenieApi.model.GenericUser;
import pl.jsystems.szkolenie.szkolenieApi.model.SimpleUser;
import pl.jsystems.szkolenie.szkolenieApi.model.User;
import pl.jsystems.szkolenie.szkolenieApi.model.error.ErrorResponse;
import pl.jsystems.szkolenie.szkolenieApi.service.AzureService;
import pl.jsystems.szkolenie.szkolenieApi.service.UserService;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

@Tags({@Tag("API"), @Tag("Azure")})
@DisplayName("ApiTest")
public class ApiTest {

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

    @DisplayName("User with devices test")
    @Test
    public void userDevices() {
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
                .body("[0].device[0].type", equalTo("computer"));
               // .body("[0].device[0].deviceModel[0].produce", equalTo("dell"));

    }

    @DisplayName("User with devices by model")
    @Test
    public void userDeviceByModel() {
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

    @DisplayName("User with devices split response")
    @Test
    public void splitResponse() {
//        given
//        when
        Response response = UserService.returnUserResponse();
        List<User> users = UserService.getUsers();

//        then
        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(users.get(0).imie).isEqualTo("Piotr");
        assertThat(users.get(0).nazwisko).isEqualTo("Kowalski");
        assertThat(users.size()).isEqualTo(2);
        assertThat(users.get(0).device.get(0).type).isEqualTo("computer");
        assertThat(users.get(0).device.get(0).deviceModel.get(0).produce).isEqualTo("dell");
        assertThat(users.get(0).device.get(0).deviceModel.get(0).screenSize).isEqualTo(17);
        assertThat(users.get(0).device.size()).isEqualTo(2);
    }

    @DisplayName("AddUser")
    @Test
    public void addUser() {
        //given
        SimpleUser user = new SimpleUser("Paweł", "Dubaj");

        //when
        List<SimpleUser> users = UserService.postUsers(user);

        //then
        System.out.println(users.toString());
        assertThat(users).isEmpty();
    }


    @DisplayName("Get simple user by id")
    @Test
    public void getSimpleUserByID() {
        //given
        long id = 1;

        //when
        SimpleUser user = UserService.getUser(id);

        //then
        assertThat(user.name).isEqualTo("Piotr");
        assertThat(user.surname).isEqualTo("Kowalski");

    }

    @DisplayName("Get user by queryParam and pathVariable")
    @Test
    public void getUserByQueryparamAndPathvariable() {
        //given
        long id = 1;

        List<String> idParams = new ArrayList();
        idParams.add("Paweł");
        idParams.add("Piotr");

        Map<String, List<String>> queryParams = new HashMap<>();
        queryParams.put("name", idParams);

        //when
        SimpleUser user = UserService.getUserByParams(queryParams, id);

        //then
        assertThat(user.name).isEqualTo("Piotr");
        assertThat(user.surname).isEqualTo("Kowalski");

    }

    @DisplayName("Error response for incorect id")
    @Test
    public void errorResponse() {
        //given
        long id = 1;

        //when
        ErrorResponse errorResponse = UserService.getErrorResponse(id);

        //then
        assertThat(errorResponse.error.errorCode).isEqualTo(400);
        assertThat(errorResponse.error.validationError).isEqualTo("invalid_email");
        assertThat(errorResponse.error.message).isEqualTo("your email is invalid");

    }

    @DisplayName("Generic type, String")
    @Test
    public void genericString() throws IOException {
        //given
        GenericUser<String> user = UserService.getGenericStringUser();

        //then
        assertThat(user.id).isEqualTo("1");

    }

    @DisplayName("Generic type, Integer")
    @Test
    public void genericInteger() throws IOException {
        //given
        GenericUser<Integer> user = UserService.getGenericIntegerUser();

        //then
        assertThat(user.id).isEqualTo(1);

    }

    @DisplayName("Azure Author")
    @Test
    public void azureAuthor() {
//        given
//        when
        Response response = AzureService.returnUserResponse();
        List<AzureUser> users = AzureService.getUsers();
        //System.out.println(users.toString());

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(users.size()>0);
        assertThat(users.get(0).id).isEqualTo(1);
        String firstName, lastName;
        for (int i=0; i<users.size(); i++)
        {
            assertThat(users.get(i).id).isEqualTo(i+1);
            assertThat(users.get(i).id).isNotNull();
            assertThat(users.get(i).idBook).isNotNull();
            assertThat(users.get(i).firstName).isNotNull();
            assertThat(users.get(i).lastName).isNotNull();
            firstName = users.get(i).firstName;
            System.out.println(firstName);
            String[] firstNameParts = firstName.split(" ");
            long firstNameLastPart = Long.parseLong(firstNameParts[2]);
            assertThat(users.get(i).id).isEqualTo(firstNameLastPart);
            lastName = users.get(i).lastName;
            String[] lastNameParts = lastName.split(" ");
            long lastNameLastPart = Long.parseLong(lastNameParts[2]);
            assertThat(users.get(i).id).isEqualTo(lastNameLastPart);
            i++;

        }

    }
}
