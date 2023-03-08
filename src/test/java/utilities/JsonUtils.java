package utilities;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtils {

    protected static ObjectMapper mapper;

    static{//static block works before every process and this object will be created once and used every class.
        mapper = new ObjectMapper();
    }
    //This method will accept two parameters and convert first parameter to second parameter data type by using ObjectMapper class.
    public static <T> T convertJsonToJava(String json, Class<T> cls){ //Generic

        T javaResult = null;
        try {

            javaResult = mapper.readValue(json, cls);

        } catch (IOException e) {

            e.printStackTrace();
        }

        return javaResult;
    }

}

