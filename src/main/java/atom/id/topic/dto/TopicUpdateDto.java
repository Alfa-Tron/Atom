package atom.id.topic.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class TopicUpdateDto {
    @NonNull
    private Long id;
    @NotBlank
    private String name;
}
