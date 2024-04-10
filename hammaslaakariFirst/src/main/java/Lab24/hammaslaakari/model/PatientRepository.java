package Lab24.hammaslaakari.model;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    List<Patient> findByUsername(String username);

    Patient findByPatientId(Long patientId);

}
