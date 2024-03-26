package atom.id.message.controllers;

import atom.id.message.dto.MessageCreateDto;
import atom.id.message.dto.MessageDto;
import atom.id.message.dto.MessageUpdateDto;
import atom.id.message.service.MessageService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/user")
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/topic/{topicId}")
    @ResponseStatus(HttpStatus.OK)
    public List<MessageDto> getMessagesOfTopicWithPagination(@PathVariable Long topicId,
                                                             @RequestParam(name = "from", defaultValue = "0") @PositiveOrZero int from,
                                                             @RequestParam(name = "size", defaultValue = "10") @Positive int size) {
        return messageService.getMessagesOfTopicWithPagination(topicId, from, size);
    }

    @PostMapping("/topic/{topicId}")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageDto addMessage(@PathVariable Long topicId, @Valid @RequestBody MessageCreateDto messageCreateDto) {
        return messageService.addMessage(topicId, messageCreateDto);
    }

    @PatchMapping("/message/{messageId}")
    @ResponseStatus(HttpStatus.OK)
    public MessageDto updateMessage(
            @PathVariable Long messageId,
            @Valid @RequestBody MessageUpdateDto messageUpdateDto) {
        return messageService.updateMessage(messageId, messageUpdateDto);
    }

    @DeleteMapping("/message/{messageId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMessage(@PathVariable Long messageId) {
        messageService.deleteMessage(messageId);
    }


}
