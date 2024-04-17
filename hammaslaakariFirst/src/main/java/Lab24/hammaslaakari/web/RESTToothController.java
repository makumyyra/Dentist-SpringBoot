package Lab24.hammaslaakari.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import Lab24.hammaslaakari.model.Tooth;
import Lab24.hammaslaakari.model.ToothRepository;
import Lab24.hammaslaakari.model.Patient;
import Lab24.hammaslaakari.model.PatientRepository;
import Lab24.hammaslaakari.model.Treatment;
import Lab24.hammaslaakari.model.TreatmentRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class RESTToothController {

    @Autowired
    private ToothRepository toothRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private TreatmentRepository treatmentRepository;

    @GetMapping("/treatments")
    public Iterable<Treatment> getTreatments() {
        return treatmentRepository.findAll();
    }

    @GetMapping("/treatments{id}")
    public @ResponseBody Optional<Treatment> findTreatmentRest(@PathVariable("id") Long treatmentId) {

        return treatmentRepository.findById(treatmentId);
    }

    @GetMapping("/patients")
    public @ResponseBody List<Patient> patientListRest() {
        return (List<Patient>) patientRepository.findAll();
    }

    @GetMapping("/patients{id}")
    public @ResponseBody Optional<Patient> findPatientRest(@PathVariable("id") Long patientId) {

        return patientRepository.findById(patientId);
    }

    @PostMapping("/treatment")
    Treatment newTreatment(@RequestBody Treatment newTreatment) {
        return treatmentRepository.save(newTreatment);
    }

}
