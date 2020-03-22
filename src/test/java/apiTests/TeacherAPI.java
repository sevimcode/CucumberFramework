package apiTests;

import ApiModels.ResponseBody;
import ApiModels.Teacher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.Config;

public class TeacherAPI{

    @Test
    public void departmentNameTest() {
        Response response = RestAssured.get ("http://api.cybertektraining.com/teacher/department/Computer");
        System.out.println (response.statusCode ());
        System.out.println (response.asString ());

        JsonPath jsonPath = response.jsonPath ();
        int size = jsonPath.getList ("teachers").size ();

        for (int i = 0;i < size;i++) {
            String path = "teachers[" + i + "].department";
            String department = jsonPath.get (path);
            System.out.println (department);
            Assert.assertEquals ("Department failed at" + i , "Computer" , department);
        }


    }

    @Test
    public void emailValidationTeacherAPI() throws JsonProcessingException {
        Response response = RestAssured.get (Config.getProperty ("baseURL") + "/teacher/all");
        System.out.println (response.statusCode ());
        System.out.println (response.asString ());

        Assert.assertEquals ("List of teachers API failed" , 200 , response.statusCode ());

        ObjectMapper objectMapper = new ObjectMapper ();
        ResponseBody responseBody = objectMapper.readValue (response.asString () , ResponseBody.class);
        System.out.println (responseBody.getTeachers ().size ());

        for (int i = 0;i < responseBody.getTeachers ().size ();i++) {

            String email = responseBody.getTeachers ().get (i).getEmailAddress ();

            if (email.contains (".") && email.contains ("@")) {
                continue;
            }
            System.out.println (email);
        }
    }

    @Test
    public void createTeacherTest() throws JsonProcessingException {

        Teacher teacher = new Teacher ();
        teacher.setFirstName ("mmms");
        teacher.setLastName ("ghdhjs");
        teacher.setJoinDate ("02/03/2020");
        teacher.setSection ("gfh");
        teacher.setSubject ("hjcgdj");
        teacher.setEmailAddress ("sshfg@hfhg.com");
        teacher.setBirthDate ("02/03/2020");
        teacher.setGender ("feamle");
        teacher.setPhone ("7497598404");
        teacher.setPassword ("dsjfhk");
        teacher.setSalary (3000);
        teacher.setPremanentAddress ("hfdhjgfjkd");
        teacher.setBatch (24);
        teacher.setDepartment ("dsjkh");
        ObjectMapper objectMapper = new ObjectMapper ();
        String teacherJson = objectMapper.writeValueAsString (teacher);
        System.out.println (teacherJson);

        Response response = RestAssured.given ().contentType (ContentType.JSON)
                .body (teacherJson).when ().post (Config.getProperty ("baseURL") + "/teacher/create");

        System.out.println (response.statusCode ());
        System.out.println (response.asString ());


    }

    @Test
    public void updateTeacherTest() throws JsonProcessingException {

        Teacher teacher = new Teacher ();
        teacher.setFirstName ("justin"); // we change update the name to justin
        teacher.setLastName ("bieber");
        teacher.setJoinDate ("02/03/2020");
        teacher.setSection ("gfh");
        teacher.setSubject ("hjcgdj");
        teacher.setEmailAddress ("sshfg@hfhg.com");
        teacher.setBirthDate ("02/03/2020");
        teacher.setGender ("feamle");
        teacher.setPhone ("7497598404");
        teacher.setPassword ("dsjfhk");
        teacher.setSalary (3000);
        teacher.setPremanentAddress ("hfdhjgfjkd");
        teacher.setBatch (24);
        teacher.setDepartment ("dsjkh");
        teacher.setTeacherId (2192); // we need id to find that teacher

        ObjectMapper objectMapper = new ObjectMapper ();
        String teacherJson = objectMapper.writeValueAsString (teacher);
        System.out.println (teacherJson);

        Response response = RestAssured.given ().contentType (ContentType.JSON)
                .body (teacherJson).when ().put (Config.getProperty ("baseURL") + "/teacher/update" );
                                          // put updates it

        System.out.println (response.statusCode ());
        System.out.println (response.asString ());
//another way
//        ObjectMapper objectMapper=new ObjectMapper();
//        Teacher teacher=new Teacher();
//        Response response=RestAssured.get(Config.getProperty("baseURL")+"/teacher/2128");
//        System.out.println(response.statusCode());
//        teacher=objectMapper.readValue(response.asString(), Teacher.class);
//        teacher.setFirstName("Justin");
//        teacher.setLastName("Bieber");


    }
}