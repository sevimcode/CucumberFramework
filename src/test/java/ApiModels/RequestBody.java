package ApiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestBody{
//there is no name clashing here it is generic it can be used from any class like student teacher or subject
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




}
