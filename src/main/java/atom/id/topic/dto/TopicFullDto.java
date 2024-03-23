package atom.id.topic.dto;

import atom.id.message.dto.MessageDto;

import java.util.List;

public class TopicFullDto {
    private Long id;
    private String topicName;

    private List<MessageDto> messages;
}
