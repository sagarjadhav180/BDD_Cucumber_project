package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class jsonReader {

    private static JSONParser jsonParser = new JSONParser();
    private static String dataPath = new File(PropertyReader.getProperty("test.data.path")).getAbsolutePath()+File.separator;
    private static JSONObject jsonObject;

    public static String readFromJson(String jsonFileName){
        try {
            FileReader file = new FileReader(dataPath + jsonFileName);
            jsonObject = (JSONObject) jsonParser.parse(file);
            if(jsonFileName == null)
                throw new RuntimeException("NO DATA FOUND in JSON file '" + jsonFileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return jsonObject.toString();
    }
}
