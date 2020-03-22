package apiTests;

import ApiModels.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;


public class StudentTest{


    @Test
    public void studentJavaObjectToJason() throws JsonProcessingException {

        Student student = new Student ();
        student.setFirstName ("jake");
        student.setLastName ("mick");
        student.setJoinDate ("03/15/2020");
        student.setBatch (14);
        student.setBirthDate ("03/02/1980");
        student.setPassword ("1234");

        Contact contact = new Contact ();
        contact.setContactId (19);
        contact.setEmailAddress ("ddd@gmail.com");
        contact.setPhone ("7673482");
        contact.setPremanentAddress ("95 main ave");

        Company company = new Company ();
        company.setCompanyId (1987);
        company.setStartDate ("03/05/2020");
        company.setPhone ("7673482");
        company.setTitle ("manager");

        Address address = new Address ();
        address.setAddressId (13);
        address.setCity ("chicago");
        address.setState ("IL");
        address.setZipCode (60007);

        student.setCompany (company);  //important we created subject object pass it to teacher
        student.setContact (contact);
        company.setAddress (address);

        ObjectMapper objectMapper = new ObjectMapper (); //converts it to JSON object
        String studentJson = objectMapper.writeValueAsString (student);
        System.out.println (studentJson);
    }


    @Test
    public void studentJsontoJavaObject() throws JsonProcessingException {
        Response response = RestAssured.get ("http://api.cybertektraining.com/student/6842");

        System.out.println (response.asString ());
        ObjectMapper objectMapper = new ObjectMapper (); //converts it to JSON object comes from jackson library
        //it helps us to convert json to java object , java object to json
        //so we can extract the data
        // we can read handle them separately
        // if don't separate them it is just a jason string

        ResponseBody rb = objectMapper.readValue (response.asString () , ResponseBody.class);
        System.out.println (rb.getStudents ().get (0).getFirstName ()); //response coming from get methods


    }

    @Test
    public void howmanystudentsJoinDateafter2020() throws JsonProcessingException {
        Response response = RestAssured.get ("http://api.cybertektraining.com/student/all");
        System.out.println (response.statusCode ());
        System.out.println (response.asString ());

        ObjectMapper objectMapper = new ObjectMapper (); //object mapper from jackson
        ResponseBody rb = objectMapper.readValue (response.asString () , ResponseBody.class);

        int count =0;
        for (int i =0; i< rb.getStudents ().size () ; i++) { //for (Student student : response)
          if ( rb.getStudents ().get (i).getCompany ().getStartDate ().endsWith ("2020") ){
              count++;
          }
        }
        System.out.println (count);
    }
}