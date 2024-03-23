package atom.id.topic.service;

import atom.id.topic.dto.TopicCreateDto;
import atom.id.topic.dto.TopicFullDto;
import atom.id.topic.dto.TopicShortDto;
import atom.id.topic.dto.TopicUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements  TopicService{
    @Override
    public TopicFullDto createTopic(TopicCreateDto topicCreateDto) {
        return null;
    }

    @Override
    public TopicShortDto updateTopic(TopicUpdateDto topicUpdateDto) {
        return null;
    }


    @Override
    public List<TopicShortDto> getTopicsWithPagination(int from, int size) {
        return null;
    }

}
