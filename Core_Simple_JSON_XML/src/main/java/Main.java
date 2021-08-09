import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        ContactInfo contactInfo = new ContactInfo("МТС", "+7(800)5553535");
        Experience experience1 = new Experience("TechD comp.","Junior JAVA developer", 1);
        Experience experience2 = new Experience("Intel", "Middle JAVA developer", 2);
        List<Experience> expArrayList = new ArrayList<>();
        expArrayList.add(experience1);
        expArrayList.add(experience2);

        User user = new User(0, 23, "Levin Tom", contactInfo, expArrayList);
        System.out.println("Original: " + user);

        //write JSON with "json-simple"
        writeJsonUser(user, "simpleJson.json");
        //read JSON with "json-simple"
        User restoredUser = readJsonUser("simpleJson.json");
        System.out.println("Restored 'json-simple': " + restoredUser);

        //write JSON with "jackson"
        writeJsonUserJackson(user, "jackson.json");
        //read JSON with "jackson"
        User restoredUserJackson = readJsonUserJackson("simpleJson.json");
        System.out.println("Restored 'Jackson': " + restoredUserJackson);


        //write JSON with "JAXB"
        writeJaxbUser(user, "jaxb.xml");
        //read JSON with "JAXB"
        User restoredUserJAXB = readJaxbUser("jaxb.xml");
        System.out.println("Restored 'JAXB': " + restoredUserJAXB);
    }

    //write JSON with "json-simple"
    public static void writeJsonUser(User user, String path){
        JSONObject fullObject = new JSONObject();
        fullObject.put("id", user.getId());
        fullObject.put("age", user.getAge());
        fullObject.put("name", user.getName());

        JSONObject contactObject = new JSONObject();
        contactObject.put("operator", user.getContactInfo().getOperator());
        contactObject.put("number", user.getContactInfo().getNumber());
        fullObject.put("contactInfo", contactObject);

        JSONArray expArray = new JSONArray();
        JSONObject expObj1 = new JSONObject();
        expObj1.put("companyName", user.getExperiencesArray().get(0).getCompanyName());
        expObj1.put("position", user.getExperiencesArray().get(0).getPosition());
        expObj1.put("ageOfExperience", user.getExperiencesArray().get(0).getAgeOfExperience());
        JSONObject expObj2 = new JSONObject();
        expObj2.put("companyName", user.getExperiencesArray().get(1).getCompanyName());
        expObj2.put("position", user.getExperiencesArray().get(1).getPosition());
        expObj2.put("ageOfExperience", user.getExperiencesArray().get(1).getAgeOfExperience());
        expArray.add(expObj1);
        expArray.add(expObj2);
        fullObject.put("experiencesArray", expArray);

        try{
            Files.write(Paths.get(path), fullObject.toJSONString().getBytes());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    //read JSON with "json-simple"
    public static User readJsonUser(String path){
        User user = null;
        try{
            FileReader fileReader = new FileReader(path);
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(fileReader);
            int id = Integer.parseInt(jsonObject.get("id").toString());
            int age = Integer.parseInt(jsonObject.get("age").toString());
            String name = jsonObject.get("name").toString();

            JSONObject contactInfoJObj = (JSONObject) jsonObject.get("contactInfo");
            String operator = contactInfoJObj.get("operator").toString();
            String number = contactInfoJObj.get("number").toString();
            ContactInfo contactInfo = new ContactInfo(operator, number);

            JSONArray experiencesArray = (JSONArray) jsonObject.get("experiencesArray");
            ArrayList<Experience> arrayListExp = new ArrayList<>();
            for(int i = 0; i < experiencesArray.size(); i++){
                JSONObject experienceJObj = (JSONObject)experiencesArray.get(i);
                String companyName = experienceJObj.get("companyName").toString();
                String position = experienceJObj.get("position").toString();
                int ageOfExperience = Integer.parseInt(experienceJObj.get("ageOfExperience").toString());
                arrayListExp.add(new Experience(companyName, position, ageOfExperience));
            }
            user = new User(id, age, name, contactInfo, arrayListExp);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return user;
    }
    //write JSON with "Jackson"
    public static void writeJsonUserJackson(User user, String path){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.writeValue(new File(path), user);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    //read JSON with "Jackson"
    public static User readJsonUserJackson(String path){
        User user = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            user = objectMapper.readValue(new File(path), User.class);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return user;
    }

    //!!! JAXB встроен с 6 версии java, но с 9 версии нужны доп. настройки в javac, maven, см. ссылку -> https://stackabuse.com/reading-and-writing-xml-in-java/
    //write XML with "JAXB
    public static void writeJaxbUser(User user, String path){
        try{
            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(user, file);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }


    }
    //read XML with "JAXB
    public static User readJaxbUser(String path){
        User user = null;
        try{
            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            user = (User) jaxbUnmarshaller.unmarshal(file);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return user;
    }
}
