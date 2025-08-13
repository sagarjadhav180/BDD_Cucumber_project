package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class HTTPHelper {

    public static Response response;

    public static Response POST(String body, String endpoint){
        RequestSpecification request = RequestSetup.requestInitiate();
        response = request
                .body(body)
                .when()
                .post(endpoint);
        return response;
    }

    public static Response GET(String endpoint){
        RequestSpecification request = RequestSetup.requestInitiate();
        response = request
                .when()
                .get(endpoint);
        return response;
    }

}
