package apiTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class MyAPI{


    @Test
    public void getTeacherList() {

        //hit api
        //hhtp method, endpoint, body, header
        Response response = RestAssured.get ("http://api.cybertektraining.com/teacher/1807");

        System.out.println (response.statusCode ());
        System.out.println (response.asString ());

        JsonPath jp = response.jsonPath ();
        String firstname = jp.get ("teachers[0].firstName");
        Assert.assertNotNull (firstname);

    }
        @Test
        public void allteachersAttributeVerification() {
            Response response = RestAssured.get ("http://api.cybertektraining.com/teacher/all");

            Assert.assertEquals (200 , response.statusCode ());
            System.out.println (response.asString ());
            JsonPath jp = response.jsonPath ();
            int size = jp.getList ("teachers").size ();
            System.out.println (size);

            //teachers[0].firstName
            for (int i = 0;i < size;i++) {

                String name = jp.get ("teachers[" + i + "].firstName");
                String email = jp.get ("teachers[" + i + "].emailAddress");
                System.out.println (name);
                System.out.println (email);

                Assert.assertNotNull (name);
                Assert.assertNotNull (email);

            }





        }

}






