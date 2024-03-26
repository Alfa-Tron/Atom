package atom.id.user.repository;

import atom.id.user.model.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserLog, Long> {
    Optional<UserLog> findByName(String userName);

    Boolean existsByName(String name);
}
