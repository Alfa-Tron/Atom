package atom.id.topic.service;

import atom.id.topic.dto.TopicCreateDto;
import atom.id.topic.dto.TopicFullDto;
import atom.id.topic.dto.TopicShortDto;
import atom.id.topic.dto.TopicUpdateDto;

import java.util.List;

public interface TopicService {
    TopicFullDto createTopic(TopicCreateDto topicCreateDto);

    TopicShortDto updateTopic(TopicUpdateDto topicUpdateDto);
    List<TopicShortDto> getTopicsWithPagination(int from, int size);

}
