package atom.id.mapper;

import atom.id.topic.dto.TopicFullDtoCreated;
import atom.id.topic.dto.TopicShortDto;
import atom.id.topic.model.Topic;

import java.util.List;

public interface TopicMapper {
    TopicFullDtoCreated topicToFullDto(Topic topic);

    TopicShortDto topicToShortDto(Topic topic);

    List<TopicShortDto> topicsToShortDtos(List<Topic> content);
}
