package atom.id.message.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto {

    private String id;
    private String text;
    private String author;
    private String created; //Раз в спецификации string, то думаю так и задумано, как и в подобных переменных других классов

}
