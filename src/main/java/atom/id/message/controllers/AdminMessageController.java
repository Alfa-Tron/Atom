package atom.id.message.controllers;


import atom.id.message.dto.MessageDto;
import atom.id.message.dto.MessageUpdateDto;
import atom.id.message.service.MessageService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/admin/message")
public class AdminMessageController {
    private final MessageService messageService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMessage(@PathVariable @Positive Long id) {
        messageService.deleteMessageAdmin(id);
    }

    @PatchMapping("/{messageId}")
    @ResponseStatus(HttpStatus.OK)
    public MessageDto updateMessage(
            @PathVariable Long messageId,
            @Valid @RequestBody MessageUpdateDto messageUpdateDto) {
        return messageService.updateMessageAdmin(messageId, messageUpdateDto);
    }
}


