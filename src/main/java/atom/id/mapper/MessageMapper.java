package atom.id.mapper;

import atom.id.message.dto.MessageDto;
import atom.id.message.model.MessageTopic;

import java.util.List;

public interface MessageMapper {
    MessageDto messageToDto(MessageTopic messageTopic);

    List<MessageDto> messageListToDtos(List<MessageTopic> messageTopics);

}
