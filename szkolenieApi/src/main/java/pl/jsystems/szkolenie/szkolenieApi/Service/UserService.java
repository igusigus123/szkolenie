package pl.jsystems.szkolenie.szkolenieApi.Service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pl.jsystems.szkolenie.szkolenieApi.User;

import java.util.List;

public class UserService extends Service {

    private static final String USER_HOST = "http://www.mocky.io/v2/5a6a58222e0000d0377a7789";

    public static Response returnUserReposnse(){
        return returnResponse(USER_HOST);
    }
    public static List<User> getUsers() {
        return returnResponseUnpack(USER_HOST).getList("", User.class);
    }

}
