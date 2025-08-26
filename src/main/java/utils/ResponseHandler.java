package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

public class ResponseHandler {

    public static <T> T deserializeResponse(Response response, Class T){

        ObjectMapper objectMapper = new ObjectMapper();
        T responseDeserialized = null;

        try{
            responseDeserialized =  (T)objectMapper.readValue(response.asString(), T);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return responseDeserialized;
    }
}
