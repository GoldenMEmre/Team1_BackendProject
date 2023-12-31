package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                //Getter, Setter ve toString() 'leri olusturur
@NoArgsConstructor   //Parametresiz Constructor olusturur
@AllArgsConstructor  //Tüm parametreleri iceren Constructor olusturur
@JsonIgnoreProperties(ignoreUnknown = true)
public class HomeworkByIdPOJ {
    private int status;
    private String message;
    private HomeworkByIdListsPOJ lists;
}
