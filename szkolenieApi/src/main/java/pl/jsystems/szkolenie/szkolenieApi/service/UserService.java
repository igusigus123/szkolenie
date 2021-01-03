package pl.jsystems.szkolenie.szkolenieApi.service;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pl.jsystems.szkolenie.szkolenieApi.model.SimpleUser;
import pl.jsystems.szkolenie.szkolenieApi.model.User;
import pl.jsystems.szkolenie.szkolenieApi.specification.Specification;

import java.util.List;

public class UserService extends Service {

//    private static final String USERS_PATH = "/5a6a58222e0000d0377a7789";
//
//    public static Response returnUserResponse(){
//
//        return returnResponseGetV2();
//    }
//    public static List<User> getUsers() {
//
//        return returnResponseGetV2Unpack().getList("", User.class);
//    }
//
//    public static JsonPath returnResponseGetV2Unpack () {
//        return returnResponseGetV2().then().extract().body().jsonPath();
//    }
//    public static Response returnResponseGetV2 () {
//        return RestAssured
//                .given()
//                .spec(Specification.requestSpecificationV2())
//                .get(USERS_PATH)
//                .andReturn();
//    }

    //drugi rodzaj pisania
//    private static final String USERS_PATH = "/5a6a58222e0000d0377a7789";
//    public static Response returnUserResponse(){
//
//        return getResponseV2(USERS_PATH);
//    }
//
//    public static List<User> getUsers() {
//
//        return getV2Unpack(USERS_PATH).getList("", User.class);
//    }
//
//    public static JsonPath getV2Unpack (String path) {
//
//        return getResponseV2(path).then().extract().body().jsonPath();
//    }
//
//    public static JsonPath postV2Unpack (String path) {
//        return postResponseV2(path).then().extract().body().jsonPath();
//    }
//
//    public static Response getResponseV2 (String path) {
//        return getSpec()
//                .get(path)
//                .andReturn();
//    }
//
//    public static Response postResponseV2 (String path) {
//        return getSpec()
//                .post(path)
//                .andReturn();
//    }
//
//    private static RequestSpecification getSpec(){
//        return RestAssured
//                .given()
//                .spec(Specification.requestSpecificationV2());
//    }

//metody post
//    private static final String USERS_PATH = "/5a6a58222e0000d0377a7789";
//    private static final String USERS_POST_PATH = "/5a690a1b2e000051007a73cb";
//
//    public static Response returnUserResponse(){
//
//        return getResponseV2(USERS_PATH);
//    }
//
//    public static List<User> getUsers() {
//
//        return getV2Unpack(USERS_PATH).getList("", User.class);
//    }
//
//    public static List<SimpleUser> postUsers(SimpleUser user) {
//
//        return postV2Unpack(USERS_POST_PATH, user).getList("", SimpleUser.class);
//    }
//
//    public static JsonPath getV2Unpack (String path) {
//
//        return getResponseV2(path).then().extract().body().jsonPath();
//    }
//
//    public static JsonPath postV2Unpack (String path, SimpleUser user) {
//        return postResponseV2(path, user).then().extract().body().jsonPath();
//    }
//
//    public static Response getResponseV2 (String path) {
//        return getSpec()
//                .get(path)
//                .andReturn();
//    }
//
//    public static Response postResponseV2 (String path, Object user) {
//        return postSpec(user)
//                .post(path)
//                .andReturn();
//    }
//
//    private static RequestSpecification getSpec(){
//        return RestAssured
//                .given()
//                .spec(Specification.requestSpecificationV2());
//    }
//
//    private static RequestSpecification postSpec(Object user){
//        return RestAssured
//                .given()
//                .spec(Specification.requestSpecificationV2())
//                .body(user);
//    }

    //po id jako parametr
    private static final String USERS_PATH = "/5a6a58222e0000d0377a7789";
    private static final String USERS_POST_PATH = "/5a690a1b2e000051007a73cb";
    private static final String USERS_BY_ID_PATH = "/5a6b69ec3100009d211b8aeb/{id}";

    public static Response returnUserResponse(){

        return getResponseV2(USERS_PATH);
    }

    public static List<User> getUsers() {

        return getV2Unpack(USERS_PATH).getList("", User.class);
    }

    public static SimpleUser getUser (long id) {
        return getV2Unpack(USERS_BY_ID_PATH, id).getObject("", SimpleUser.class);
    }

    public static List<SimpleUser> postUsers(SimpleUser user) {

        return postV2Unpack(USERS_POST_PATH, user).getList("", SimpleUser.class);
    }

    public static JsonPath getV2Unpack (String path, Object... params) {

        return getResponseV2(path, params).then().extract().body().jsonPath();
    }

    public static JsonPath postV2Unpack (String path, SimpleUser user) {
        return postResponseV2(path, user).then().extract().body().jsonPath();
    }

    public static Response getResponseV2 (String path, Object... params) {
        return getSpec()
                .get(path, params)
                .andReturn();
    }

    public static Response postResponseV2 (String path, Object user) {
        return postSpec(user)
                .post(path)
                .andReturn();
    }

    private static RequestSpecification getSpec(){
        return RestAssured
                .given()
                .spec(Specification.requestSpecificationV2());
    }

    private static RequestSpecification postSpec(Object user){
        return RestAssured
                .given()
                .spec(Specification.requestSpecificationV2())
                .body(user);
    }
}
