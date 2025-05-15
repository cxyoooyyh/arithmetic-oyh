package www.oyh.com.day4_30;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author sharkCode
 * @date 2025/4/30 16:33
 */
public class SerializationJson {
    public static void main(String[] args) {
        serializationJackson(new Person("oyh", 18));
    }

    public static void serializationJackson(Person person){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonString = mapper.writeValueAsString(person);
            System.out.println(jsonString);
            Person person2 = mapper.readValue(jsonString, Person.class);
            System.out.println(person2);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

