package atom.id.mapper;

import atom.id.message.dto.MessageDto;
import atom.id.message.model.MessageTopic;
import atom.id.topic.dto.TopicFullDtoCreated;
import atom.id.topic.dto.TopicShortDto;
import atom.id.topic.model.Topic;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TopicMapperImpl implements TopicMapper {
    private final MessageMapper messageMapper;

    @Override
    public TopicFullDtoCreated topicToFullDto(Topic topic) {
        return new TopicFullDtoCreated(topic.getId(), topic.getTopicName(), topic.getAuthorName(), messageListToDtos(topic.getMessages()), topic.getCreated());
    }

    @Override
    public TopicShortDto topicToShortDto(Topic topic) {
        return new TopicShortDto(topic.getId(), topic.getTopicName());
    }

    @Override
    public List<TopicShortDto> topicsToShortDtos(List<Topic> content) {
        return content.stream()
                .map(this::topicToShortDto)
                .collect(Collectors.toList());
    }

    private List<MessageDto> messageListToDtos(List<MessageTopic> list) {
        return list.stream()
                .map(messageMapper::messageToDto)
                .collect(Collectors.toList());
    }

}
