package atom.id.topic.controllers;

import atom.id.topic.dto.TopicCreateDto;
import atom.id.topic.dto.TopicFullDto;
import atom.id.topic.dto.TopicShortDto;
import atom.id.topic.dto.TopicUpdateDto;
import atom.id.topic.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/topic")
@Validated
public class TopicController {
    private final TopicService topicService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TopicFullDto createNewTopic(@Valid @RequestBody TopicCreateDto newTopic) {
        return topicService.createTopic(newTopic);
    }

    @PatchMapping
    public TopicShortDto updateTopic(@Valid @RequestBody TopicUpdateDto updateTopic) {
        return topicService.updateTopic(updateTopic);
    }

    @GetMapping
    private List<TopicShortDto> getTopicsWithPagination(@RequestParam(name = "from", defaultValue = "0") @PositiveOrZero int from,
                                                        @RequestParam(name = "size", defaultValue = "10") @Positive int size) {
        return topicService.getTopicsWithPagination(from, size);
    }

}
