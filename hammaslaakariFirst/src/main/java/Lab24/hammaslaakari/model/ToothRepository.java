package Lab24.hammaslaakari.model;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ToothRepository extends CrudRepository<Tooth, Long> {
    List<Tooth> findByToothname(String toothname);
}
