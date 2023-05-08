package itstep.task_5;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class XMLParser {

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
        user.setName("Misha");
        user.setAge(33);
        user.setPhoneList(Arrays.asList("1111","22222"));
        System.out.println(user);

        //step 2 object to xml string
        XmlMapper xmlMapper =new XmlMapper();
        String stringXML=xmlMapper.writeValueAsString(user);
        System.out.println("stringXML: "+stringXML);

        //step 3 read xml file to object
        User inputXmlUser=xmlMapper.readValue(new File("input.xml"),User.class);
        System.out.println("inputXmlUser: "+inputXmlUser);

        //step 4 change data in User and save to xml file
        inputXmlUser.getPhoneList().add("33333");
        xmlMapper.writeValue(new File("output.xml"),inputXmlUser);
        System.out.println("updated inputXmlUser: "+inputXmlUser);

    }
}
