package Lab24.hammaslaakari.model;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    Patient findByUsername(String username);

}
