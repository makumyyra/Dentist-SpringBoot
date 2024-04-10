package Lab24.hammaslaakari.model;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface TreatmentRepository extends CrudRepository<Treatment, Long> {
    Optional<Treatment> findById(Long patientid);

    // boolean existsByToothAndPatient(Long toothid, Long patientid);
    boolean existsByToothAndPatient(Tooth tooth, Patient patient);

    // boolean existsToothById(Long toothid);

    // boolean existsPatientById(Patient patient);
}
