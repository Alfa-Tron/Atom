package atom.id.topic.service;

import atom.id.Exeption.AccessException;
import atom.id.Exeption.ObjectNotFoundException;
import atom.id.mapper.TopicMapper;
import atom.id.message.model.MessageTopic;
import atom.id.message.repositories.MessageTopicRepository;
import atom.id.topic.dto.TopicCreateDto;
import atom.id.topic.dto.TopicFullDtoCreated;
import atom.id.topic.dto.TopicShortDto;
import atom.id.topic.dto.TopicUpdateDto;
import atom.id.topic.model.Topic;
import atom.id.topic.repositories.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;
    private final MessageTopicRepository messageTopicRepository;

    @Override
    public TopicFullDtoCreated createTopic(TopicCreateDto topicCreateDto) {
        Topic topic = new Topic();
        topic.setTopicName(topicCreateDto.getTopicName());
        LocalDateTime timeCreated = LocalDateTime.now();
        topic.setCreated(timeCreated);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        topic.setAuthorName(username);

        topic = topicRepository.save(topic);

        MessageTopic messageTopic = new MessageTopic();
        messageTopic.setText(topicCreateDto.getMessage().getText());
        messageTopic.setNameAuthor(username);
        messageTopic.setDate(timeCreated);
        messageTopic.setTopic(topic);

        List<MessageTopic> messageTopics = new ArrayList<>();
        messageTopics.add(messageTopic);
        topic.setMessages(messageTopics);

        messageTopicRepository.save(messageTopic);
        return topicMapper.topicToFullDto(topic);
    }

    @Override
    public TopicShortDto updateTopic(TopicUpdateDto topicUpdateDto) {
        Long id = topicUpdateDto.getId();
        Topic topic = topicRepository.findById(topicUpdateDto.getId()).orElseThrow(() -> new ObjectNotFoundException(String.format("Topic with id=%s was not found", id)));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        if (!topic.getAuthorName().equals(username)) {
            throw new AccessException(String.format("Not access for topic id=%s", id));
        }
        topic.setTopicName(topicUpdateDto.getName());
        topicRepository.save(topic);
        return topicMapper.topicToShortDto(topic);
    }


    @Override
    public List<TopicShortDto> getTopicsWithPagination(int from, int size) {
        Pageable pageable = PageRequest.of(from / size, size);

        Page<Topic> events = topicRepository.findAll(pageable);
        if (events.getContent().isEmpty()) {
            throw new ObjectNotFoundException("Topics not found");
        }
        return topicMapper.topicsToShortDtos(events.getContent());
    }

    @Override
    public void deleteTopic(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        if (topicRepository.existsByIdAndAuthorName(id, username)) {
            topicRepository.deleteById(id);
        } else {
            throw new AccessException(String.format("Not access for message id=%s", id));
        }


    }

    @Override
    public void deleteTopicAdmin(Long id) {
        topicRepository.deleteById(id);

    }

    @Override
    public TopicShortDto updateTopicAdmin(TopicUpdateDto updateTopic) {
        Long id = updateTopic.getId();
        Topic topic = topicRepository.findById(updateTopic.getId()).orElseThrow(() -> new ObjectNotFoundException(String.format("Topic with id=%s was not found", id)));
        topic.setTopicName(updateTopic.getName());
        return topicMapper.topicToShortDto(topic);
    }
}