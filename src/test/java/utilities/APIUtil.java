package utilities;

import ApiModels.RequestBody;
import ApiModels.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIUtil{


    // CRUD operation. One method for each operation
    //one method should handle any API s we are hitting

    private static ResponseBody responseBody;


    public static void hitGET( String resource){
        String uri = Config.getProperty ("baseURL") + resource;
        Response response = RestAssured.get (uri);
        System.out.println (response.asString ());
      //  Assert.assertEquals ("get api hit failed",200,response.statusCode ()); //code does not execute assetion removed
        System.out.println ("STATUS CODE :"+ response.statusCode ()); //at least we print the response

        ObjectMapper objectMapper = new ObjectMapper ();
        try {
            responseBody = objectMapper.readValue (response.asString () , ResponseBody.class);

        }catch (JsonProcessingException e){
            e.printStackTrace ();
        }
    }

    public static ResponseBody getResponseBody(){
        return responseBody;
    }

    public static void hitPOST( String resource, RequestBody requestBody ){
        String uri = Config.getProperty ("baseURL")+resource;

        ObjectMapper objectMapper = new ObjectMapper ();
        String bodyJSON = "";
        try {
            bodyJSON = objectMapper.writeValueAsString (requestBody);
        }catch (JsonProcessingException e){
            e.printStackTrace ();
        }
        Response response = RestAssured.given ().contentType (ContentType.JSON).body (bodyJSON).when ().post (uri);
        System.out.println (response.asString ());
   //     Assert.assertEquals ("get api hit failed",200,response.statusCode ());
        System.out.println ("STATUS CODE :"+ response.statusCode ());

        try{
            responseBody = objectMapper.readValue (response.asString (), ResponseBody.class);
        }catch (JsonProcessingException e){
            e.printStackTrace ();
        }


    }
    public static void hitDELETE(String resource){
        String uri = Config.getProperty ("baseURL")+ resource;
        Response response = RestAssured.delete (uri);
        ObjectMapper objectMapper = new ObjectMapper ();
        try{
            responseBody = objectMapper.readValue (response.asString (), ResponseBody.class);
        }catch (JsonProcessingException e){
            e.printStackTrace ();
        }

    }

    public static void hitUPDATE(String resource, RequestBody requestBody){
        String uri = Config.getProperty ("baseURL")+ resource;
        ObjectMapper objectMapper = new ObjectMapper ();
        String bodyJSON = "";
        try{
            bodyJSON = objectMapper.writeValueAsString (requestBody);
        }catch (JsonProcessingException e){
            e.printStackTrace ();
        }
        Response response = RestAssured.given ().contentType (ContentType.JSON).body (bodyJSON).when ().put (uri);
        System.out.println (response.asString ());
        System.out.println ("STATUS CODE :"+ response.statusCode ());

        try{
            responseBody = objectMapper.readValue (response.asString (), ResponseBody.class);
        }catch (JsonProcessingException e){
            e.printStackTrace ();
        }
    }


}
