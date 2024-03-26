package atom.id.topic.service;

import atom.id.topic.dto.TopicCreateDto;
import atom.id.topic.dto.TopicFullDtoCreated;
import atom.id.topic.dto.TopicShortDto;
import atom.id.topic.dto.TopicUpdateDto;

import java.util.List;

public interface TopicService {
    TopicFullDtoCreated createTopic(TopicCreateDto topicCreateDto);

    TopicShortDto updateTopic(TopicUpdateDto topicUpdateDto);

    List<TopicShortDto> getTopicsWithPagination(int from, int size);

    void deleteTopic(Long id);

    void deleteTopicAdmin(Long id);

    TopicShortDto updateTopicAdmin(TopicUpdateDto updateTopic);
}
