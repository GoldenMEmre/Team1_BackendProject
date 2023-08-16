package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                //Getter, Setter ve toString() 'leri olusturur
@NoArgsConstructor   //Parametresiz Constructor olusturur
@AllArgsConstructor  //Tüm parametreleri iceren Constructor olusturur
public class HomeworkByIdListsPOJ {

    private String id;
    private String class_id;
    private String section_id;
    private String session_id;
    private String staff_id;
    private String subject_group_subject_id;
    private String subject_id;
    private String homework_date;
    private String submit_date;
    private String marks;
    private String description;
    private String create_date;
    private String evaluation_date;
    private String document;
    private String created_by;
    private String evaluated_by;
    private String created_at;
    private String subject_name;
    private String subject_groups_id;
    private String name;
    private String assignments;
}
