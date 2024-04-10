package Lab24.hammaslaakari.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

    Optional<Message> findById(Long messageid);
}
