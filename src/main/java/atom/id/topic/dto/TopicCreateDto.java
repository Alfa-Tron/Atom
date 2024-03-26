package atom.id.topic.dto;

import atom.id.message.dto.MessageCreateDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicCreateDto {
    @NotBlank
    private String topicName;
    private MessageCreateDto message;
}
