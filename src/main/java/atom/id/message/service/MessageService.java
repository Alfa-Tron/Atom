package atom.id.message.service;

import atom.id.message.dto.MessageDto;
import atom.id.message.dto.MessageUpdateDto;

import java.util.List;

public interface MessageService {
    List<MessageDto> getMessagesOfTopicWithPagination(Long topicId, int from,int size);
    MessageDto addMessage(Long topicId);
    MessageDto updateMessage(Long topicId, Long messageId, MessageUpdateDto messageUpdateDto);
    void deleteMessage(Long messageId);
}
