package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String,Object> expectedDataMap(Integer userId, String title, Boolean completed){
        Map<String,Object>expectedData = new HashMap<>();
        if (userId!=null) {
            expectedData.put("userId", 21);
        }
        if (title!=null) {
            expectedData.put("title", "Wash the dishes");
        }
        if (completed!=null) {
            expectedData.put("completed", false);
        }
        return expectedData;
    }
    public static String expectedDataInString(Integer userId, String title, Boolean completed){

        return "{\n" +
                "\"userId\": "+userId+",\n" +
                "\"title\": \""+title+"\",\n" +
                "\"completed\": "+completed+"\n" +
                "}";

    }
}
