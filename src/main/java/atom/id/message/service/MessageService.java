package atom.id.message.service;

import atom.id.message.dto.MessageCreateDto;
import atom.id.message.dto.MessageDto;
import atom.id.message.dto.MessageUpdateDto;

import java.util.List;

public interface MessageService {
    List<MessageDto> getMessagesOfTopicWithPagination(Long topicId, int from, int size);

    MessageDto addMessage(Long topicId, MessageCreateDto messageCreateDto);

    MessageDto updateMessage(Long messageId, MessageUpdateDto messageUpdateDto);

    void deleteMessage(Long id);

    void deleteMessageAdmin(Long id);

    MessageDto updateMessageAdmin(Long messageId, MessageUpdateDto messageUpdateDto);
}
