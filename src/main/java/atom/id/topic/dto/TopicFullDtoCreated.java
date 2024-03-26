package atom.id.topic.dto;

import atom.id.message.dto.MessageDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class TopicFullDtoCreated {
    private Long id;
    private String topicName;
    private String authorName;

    private List<MessageDto> messages;
    private LocalDateTime created;

    public TopicFullDtoCreated(Long id, String topicName, String authorName, List<MessageDto> messages, LocalDateTime created) {
        this.id = id;
        this.topicName = topicName;
        this.messages = messages;
        this.created = created;
        this.authorName = authorName;
    }
}
