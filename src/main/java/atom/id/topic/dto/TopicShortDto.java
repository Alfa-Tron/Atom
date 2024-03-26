package atom.id.topic.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicShortDto {
    private Long id;
    private String topicName;

    public TopicShortDto(Long id, String topicName) {
        this.id = id;
        this.topicName = topicName;
    }
}
