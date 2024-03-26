package atom.id.topic.controllers;

import atom.id.topic.dto.TopicCreateDto;
import atom.id.topic.dto.TopicFullDtoCreated;
import atom.id.topic.dto.TopicShortDto;
import atom.id.topic.dto.TopicUpdateDto;
import atom.id.topic.service.TopicService;
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
@RequestMapping(path = "/user/topic")
@Validated
public class TopicController {
    private final TopicService topicService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TopicFullDtoCreated createNewTopic(@Valid @RequestBody TopicCreateDto newTopic) {
        return topicService.createTopic(newTopic);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public TopicShortDto updateTopic(@Valid @RequestBody TopicUpdateDto updateTopic) {
        return topicService.updateTopic(updateTopic);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TopicShortDto> getTopicsWithPagination(@RequestParam(name = "from", defaultValue = "0") @PositiveOrZero int from,
                                                       @RequestParam(name = "size", defaultValue = "10") @Positive int size) {
        return topicService.getTopicsWithPagination(from, size);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTopic(@PathVariable @Positive Long id) {
        topicService.deleteTopic(id);
    }

}
