package atom.id.message.service;

import atom.id.Exeption.AccessException;
import atom.id.Exeption.ObjectNotFoundException;
import atom.id.mapper.MessageMapper;
import atom.id.message.dto.MessageCreateDto;
import atom.id.message.dto.MessageDto;
import atom.id.message.dto.MessageUpdateDto;
import atom.id.message.model.MessageTopic;
import atom.id.message.repositories.MessageTopicRepository;
import atom.id.topic.repositories.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageTopicRepository messageTopicRepository;
    private final TopicRepository topicRepository;
    private final MessageMapper messageMapper;

    @Override
    public List<MessageDto> getMessagesOfTopicWithPagination(Long topicId, int from, int size) {
        Pageable pageable = PageRequest.of(from / size, size);
        List<MessageTopic> messageTopics = messageTopicRepository.findByTopicId(topicId, pageable);
        if (messageTopics.isEmpty()) {
            throw new ObjectNotFoundException("Messages not found");
        }
        return messageMapper.messageListToDtos(messageTopics);
    }

    @Override
    public MessageDto addMessage(Long topicId, MessageCreateDto messageCreateDto) {
        MessageTopic messageTopic = new MessageTopic();
        messageTopic.setTopic(topicRepository.findById(topicId).orElseThrow(() -> new ObjectNotFoundException(String.format("Topic with id=%s was not found", topicId))));
        messageTopic.setText(messageCreateDto.getText());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        messageTopic.setNameAuthor(username);
        messageTopic.setDate(LocalDateTime.now());
        messageTopicRepository.save(messageTopic);
        return messageMapper.messageToDto(messageTopic);
    }

    @Override
    public MessageDto updateMessage(Long messageId, MessageUpdateDto messageUpdateDto) {
        MessageTopic messageTopic = messageTopicRepository.findById(messageId).orElseThrow(() -> new ObjectNotFoundException(String.format("Message with id=%s was not found", messageId)));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        if (messageTopic.getNameAuthor().equals(username)) {
            messageTopic.setDate(LocalDateTime.now());
            messageTopic.setText(messageTopic.getText());
        } else {
            throw new AccessException(String.format("Not access for message id=%s", messageId));
        }

        return messageMapper.messageToDto(messageTopic);
    }

    @Override
    public void deleteMessage(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        if (messageTopicRepository.existsByIdAndNameAuthor(id, username)) {
            messageTopicRepository.deleteById(id);
        } else {
            throw new AccessException(String.format("Not access for message id=%s", id));
        }

    }

    @Override
    public void deleteMessageAdmin(Long id) {
        messageTopicRepository.deleteById(id);
    }

    @Override
    public MessageDto updateMessageAdmin(Long messageId, MessageUpdateDto messageUpdateDto) {
        MessageTopic messageTopic = messageTopicRepository.findById(messageId).orElseThrow(() -> new ObjectNotFoundException(String.format("Message with id=%s was not found", messageId)));
        messageTopic.setDate(LocalDateTime.now());
        messageTopic.setText(messageTopic.getText());
        return messageMapper.messageToDto(messageTopic);
    }


}
