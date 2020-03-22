package ApiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Teacher{

    int teacherId;
    String firstName;
    String lastName;
    String emailAddress;
    String joinDate;
    int batch;
    String birthDate;
    String gender;
    String department;
    String password;
    String phone;
    String premanentAddress;
    String section;
    String subject;
    int salary;
 //   Subject subject; // gives mismatch exception



}
