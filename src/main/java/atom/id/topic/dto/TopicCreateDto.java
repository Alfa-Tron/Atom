package atom.id.topic.dto;

import atom.id.message.dto.MessageDto;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicCreateDto {
    @NotBlank
    private String topicName;
    @NotNull
    private MessageDto message;
}
