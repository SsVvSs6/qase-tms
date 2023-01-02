package tms.onl.adapter;

import com.google.gson.Gson;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static tms.onl.utils.StringConstant.*;

public class BaseAdapter {

    protected Gson converter = new Gson();

    protected Response get(String url) {
        return given()
                .header(TOKEN_NAME, TOKEN_VALUE)
                .when()
                .get(BASE_URL + url)
                .then()
                .log().all()
                .extract().response();
    }

    protected Response post(String url, String body) {
        return given()
                .header(TOKEN_NAME, TOKEN_VALUE)
                .header(CONTENT_TYPE, JSON)
                .body(body)
                .when()
                .post(BASE_URL + url)
                .then()
                .log().all()
                .extract().response();
    }

    protected Response delete(String url) {
        return given()
                .header(TOKEN_NAME, TOKEN_VALUE)
                .when()
                .delete(BASE_URL + url)
                .then()
                .log().all()
                .extract().response();
    }
}
