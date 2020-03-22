package ApiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data  //comes from lombok so we dont need getters and setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT) // when we create model class object to json it is not getting null values
@JsonIgnoreProperties(ignoreUnknown = true) // it is ignoring unknown attributes if you don't want to get one attribute
public class Student{

    int studentId;
    String firstName;
    String lastName;
    int batch;
    String joinDate;
    String birthDate;
    String password;
    Contact contact;
    Company company;



}
