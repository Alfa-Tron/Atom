package atom.id.message.service;

import atom.id.message.dto.MessageDto;
import atom.id.message.dto.MessageUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements  MessageService{

    @Override
    public List<MessageDto> getMessagesOfTopicWithPagination(Long topicId, int from, int size) {
        return null;
    }

    @Override
    public MessageDto addMessage(Long topicId) {
        return null;
    }

    @Override
    public MessageDto updateMessage(Long topicId, Long messageId, MessageUpdateDto messageUpdateDto) {
        return null;
    }

    @Override
    public void deleteMessage(Long messageId) {

    }

}
