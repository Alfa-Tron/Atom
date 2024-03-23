package atom.id.message.controllers;

import atom.id.message.dto.MessageDto;
import atom.id.message.dto.MessageUpdateDto;
import atom.id.message.service.MessageService;
import atom.id.topic.dto.TopicUpdateDto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/topic/{topicId}")
    public List<MessageDto> getMessagesOfTopicWithPagination(@PathVariable Long topicId,
                                               @RequestParam(name = "from", defaultValue = "0") @PositiveOrZero int from,
                                               @RequestParam(name = "size", defaultValue = "10") @Positive int size) {
        return  messageService.getMessagesOfTopicWithPagination(topicId,from,size);
    }

    @PostMapping("/topic/{topicId}")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageDto addMessage(@PathVariable Long topicId){
        return messageService.addMessage(topicId);
    }

    @PatchMapping("/topic/{topicId}/message/{messageId}")
    public MessageDto updateMessage(@PathVariable Long topicId,
                                    @PathVariable Long messageId,
                                    @Valid @RequestBody MessageUpdateDto messageUpdateDto){
        return messageService.updateMessage(topicId,messageId,messageUpdateDto);
    }

    @DeleteMapping("/message/{messageId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMessage(@PathVariable Long messageId){
        messageService.deleteMessage(messageId);
    }



}
