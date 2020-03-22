package apiTests;

import ApiModels.Subject;
import ApiModels.Teacher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class TeacherJacksonTestClass{



    @Test
    public void jackson() throws JsonProcessingException {
        Teacher teacher = new Teacher ();
        teacher.setEmailAddress ("gson@gmail.com");
        teacher.setFirstName ("jake");
        teacher.setLastName ("mick");
        teacher.setJoinDate ("03/15/2020");
        teacher.setSalary (5000);


        Subject subject = new Subject ();
        subject.setYear (2020);
        subject.setName ("automation");
        subject.setBatch (14);

     //   teacher.setSubject (subject);  //important we created subject object pass it to teacher

        ObjectMapper objectMapper = new ObjectMapper (); //
        String teacherJson = objectMapper.writeValueAsString (teacher);
        System.out.println (teacherJson);




    }
}
