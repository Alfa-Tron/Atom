package atom.id.mapper;

import atom.id.message.dto.MessageDto;
import atom.id.message.model.MessageTopic;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessageMapperImpl implements MessageMapper {
    @Override
    public MessageDto messageToDto(MessageTopic messageTopic) {
        MessageDto messageDto = new MessageDto();
        messageDto.setAuthor(messageTopic.getNameAuthor());
        messageDto.setId(messageTopic.getId());
        messageDto.setText(messageTopic.getText());
        messageDto.setCreated(messageTopic.getDate().toString());
        return messageDto;
    }

    @Override
    public List<MessageDto> messageListToDtos(List<MessageTopic> messageTopics) {
        return messageTopics.stream()
                .map(this::messageToDto)
                .collect(Collectors.toList());
    }

}
