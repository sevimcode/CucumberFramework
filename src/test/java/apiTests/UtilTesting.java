package apiTests;

import ApiModels.RequestBody;
import ApiModels.Student;
import ApiModels.Teacher;
import org.junit.Assert;
import org.junit.Test;
import utilities.APIUtil;

public class UtilTesting{


    @Test
    public void teacherTesting() {

        String resource = "/teacher/2192";
        APIUtil.hitGET (resource);
        System.out.println (APIUtil.getResponseBody ().getTeachers ().get (0).getFirstName ());

        //APIUtil.getResponseBody () == ResponseBody object
    }

    @Test
    public void allTeachersTest() {

        APIUtil.hitGET ("/teacher/all");
        for (Teacher t : APIUtil.getResponseBody ().getTeachers ()) {
            if (t.getGender ().equalsIgnoreCase ("female")) {
                System.out.println (t.getFirstName ());
            }
        }
    }

    @Test
    public void batchTesting() {

        APIUtil.hitGET ("/student/all");
        int index = 0;
        for (Student t : APIUtil.getResponseBody ().getStudents ()) {
            if (t.getBatch () >= 7 && t.getBatch () <= 14) {
                index++;
                continue;

            }
            Assert.fail ("student batch failed at" + index);
            System.out.println (t.getFirstName ());
            System.out.println (( t.getBatch () ));
        }
    }


    @Test
    public void postTesting() {
        RequestBody teacher = new RequestBody ();

        teacher.setFirstName ("mike"); // we change update the name to justin
        teacher.setLastName ("ronaldo");
        teacher.setJoinDate ("02/03/2020");
        teacher.setSection ("gfh");
        teacher.setSubject ("hjcgdj");
        teacher.setEmailAddress ("sshfg@hfhg.com");
        teacher.setBirthDate ("02/03/2020");
        teacher.setGender ("female");
        teacher.setPhone ("7497598404");
        teacher.setPassword ("dsjfhk");
        teacher.setSalary (3000);
        teacher.setPremanentAddress ("hfdhjgfjkd");
        teacher.setBatch (24);
        teacher.setDepartment ("dsjkh");

        APIUtil.hitPOST ("/teacher/create" , teacher); // data type is requestBody


    }

    @Test
    public void deleteTesting() {
        String resource = "/teacher/delete/1351";
        APIUtil.hitDELETE (resource);


    }

    @Test
    public void updateTesting() {

        RequestBody teacher = new RequestBody ();
        teacher.setTeacherId (4563);
        teacher.setFirstName ("mike"); // we change update the name to justin
        teacher.setLastName ("ronaldo");
        teacher.setJoinDate ("02/03/2020");
        teacher.setSection ("gfh");
        teacher.setSubject ("hjcgdj");
        teacher.setEmailAddress ("sshfg@hfhg.com");
        teacher.setBirthDate ("02/03/2020");
        teacher.setGender ("female");
        teacher.setPhone ("7497598404");
        teacher.setPassword ("dsjfhk");
        teacher.setSalary (3000);
        teacher.setPremanentAddress ("hfdhjgfjkd");
        teacher.setBatch (24);
        teacher.setDepartment ("dsjkh");

        APIUtil.hitUPDATE ("/teacher/update/2918" , teacher); // data type is requestBody



        }
    }
