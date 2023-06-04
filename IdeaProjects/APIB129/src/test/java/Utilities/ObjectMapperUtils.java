package Utilities;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {
    //<T> T--> herahngi bir data tipini temsil eder.
    //readValue() methodu birinci parametrede belirtilen String json datayı ikinci parametrede belirtilen data tipine çevirir.

    public static <T> T convertJsonToJava(String json, Class<T>cls){//generic method
        try {
            return new ObjectMapper().readValue(json, cls);
        }catch (JsonProcessingException e){
            throw  new RuntimeException(e);
        }
    }


}
