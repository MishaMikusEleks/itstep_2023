package itstep.task_5;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class JsonParser {

    public static void main(String[] args) throws IOException {
        //Json, Xml wrappers
        //Make some complex models with few fields.
        //Make it serializable.
        //Read some json from “input.json”
        //and deserialize it to POJO.
        //Then change a few fields and save it to “output.json”.

        //The same for xml.

        //step 1 init object
        User user=new User();
        user.setName("json Misha");
        user.setAge(33);
        user.setPhoneList(Arrays.asList("1111","22222"));
        System.out.println(user);

        //step 2 object to json string
        ObjectMapper objectMapper =new ObjectMapper();
        String stringJson=objectMapper.writeValueAsString(user);
        System.out.println("stringJson: "+stringJson);

        //step 3 read xml file to object
        User inputJsonUser=objectMapper.readValue(new File("input.json"),User.class);
        System.out.println("inputJsonUser: "+inputJsonUser);

        //step 4 change data in User and save to xml file
        inputJsonUser.getPhoneList().add("33333");
        objectMapper.writeValue(new File("output.json"),inputJsonUser);
        System.out.println("updated inputJsonUser: "+inputJsonUser);

        //step 5 work with JSONObject
        JSONObject jsonObject1 = new JSONObject("{\"_\":\"json Misha\",\"age\":\"33\",\"phoneList\":[\"1111\",\"22222\"]}");
        System.out.println("jsonObject1:"+jsonObject1);
        jsonObject1.getJSONArray("phoneList").forEach(System.out::println);

        JSONObject jsonObject2 = new JSONObject();
        System.out.println("jsonObject2:"+jsonObject2);

        JSONObject jsonObject3 = new JSONObject(new User());
        System.out.println("jsonObject3:"+jsonObject3);
    }
}
