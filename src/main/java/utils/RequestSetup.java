package utils;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RequestSetup {

    private static RequestSpecification requestSpecification;

    public  static RequestSpecification requestInitiate(){
        requestSpecification = RestAssured
                .given()
                .baseUri(PropertyReader.getProperty("baseURL"))
                .contentType("application/json");
         return requestSpecification;
    }


}
