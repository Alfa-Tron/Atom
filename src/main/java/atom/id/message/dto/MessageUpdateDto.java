package atom.id.message.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageUpdateDto {
    @NotBlank
    private String text;

}
