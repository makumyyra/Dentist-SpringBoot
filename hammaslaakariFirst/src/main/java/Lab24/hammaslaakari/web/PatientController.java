package Lab24.hammaslaakari.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Lab24.hammaslaakari.model.Patient;
import Lab24.hammaslaakari.model.PatientRepository;

public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin_index")
    public String adminIndex(Model model) {
        List<String> patientNames = patientRepository.findDistinctPatientNames();
        model.addAttribute("patientnames", patientNames);
        return "admin_index";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/seePatientDetails")
    public String seeDetails(@PathVariable("patientid") Long id, Model model) {
        model.addAttribute("patient", patientRepository.findById(id));
        return "seeDetails";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/editPatient/{patientid}")
    public String editPatient(@PathVariable("patientid") Long id, Model model) {
        model.addAttribute("patient", patientRepository.findById(id));
        return "editPatient";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{patientid}")
    public String deletePatient(@PathVariable("patientid") Long patientid, Model model) {
        patientRepository.deleteById(patientid);
        return "redirect:/admin_index";
    }

    @PostMapping("/savepatient")
    public String savePatient(Patient patient) {
        patientRepository.save(patient);
        return "redirect:/admin_index";
    }

}
