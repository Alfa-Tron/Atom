package atom.id.message.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto {
    private Long id;
    private String text;
    private String author;
    private String created;
}
