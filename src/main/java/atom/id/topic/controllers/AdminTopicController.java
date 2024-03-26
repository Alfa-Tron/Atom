package atom.id.topic.controllers;

import atom.id.topic.dto.TopicShortDto;
import atom.id.topic.dto.TopicUpdateDto;
import atom.id.topic.service.TopicService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/admin/topic")
public class AdminTopicController {
    private final TopicService topicService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTopic(@PathVariable @Positive Long id) {
        topicService.deleteTopicAdmin(id);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public TopicShortDto updateTopic(@Valid @RequestBody TopicUpdateDto updateTopic) {
        return topicService.updateTopicAdmin(updateTopic);
    }
}
