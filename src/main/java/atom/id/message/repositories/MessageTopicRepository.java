package atom.id.message.repositories;

import atom.id.message.model.MessageTopic;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageTopicRepository extends JpaRepository<MessageTopic, Long> {
    List<MessageTopic> findByTopicId(Long topicId, Pageable pageable);

    boolean existsByIdAndNameAuthor(Long id, String name);

}
