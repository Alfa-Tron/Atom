package atom.id.topic.model;

import atom.id.message.model.MessageTopic;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String topicName;
    @Column(nullable = false)
    private String authorName;
    @Column(nullable = false)
    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<MessageTopic> messages;
    @Column(nullable = false)
    private LocalDateTime created;
}
