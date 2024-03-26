package atom.id.topic.repositories;

import atom.id.topic.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    boolean existsByIdAndAuthorName(Long id, String name);

}
