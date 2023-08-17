package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data                //Getter, Setter ve toString() 'leri olusturur
@NoArgsConstructor   //Parametresiz Constructor olusturur
@AllArgsConstructor  //Tüm parametreleri iceren Constructor olusturur
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetStudentClassListsPOJO {

    private String admission_no;
    private String roll_no;
    private String session_id;
    private String class_id;
    private String section_id;
    private String id;
    private String student_id;
    private String section;
    private String firstname;
    private String middlename;
    private String lastname;
    private String dob;
    private String guardian_name;

}
