package Lab24.hammaslaakari.web;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.yaml.snakeyaml.extensions.compactnotation.PackageCompactConstructor;

import Lab24.hammaslaakari.model.AppUserRepository;
import Lab24.hammaslaakari.model.Message;
import Lab24.hammaslaakari.model.MessageRepository;
import Lab24.hammaslaakari.model.Patient;
import Lab24.hammaslaakari.model.PatientRepository;
import Lab24.hammaslaakari.model.Tooth;
import Lab24.hammaslaakari.model.ToothRepository;
import Lab24.hammaslaakari.model.Treatment;
import Lab24.hammaslaakari.model.TreatmentRepository;
import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class DentistController {

    @Autowired
    private ToothRepository toothRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private TreatmentRepository treatmentRepository;

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/user_index")
    public String userIndexPage(Model model) {
        return "user_index";
    }

    @GetMapping("/toothlist")
    public String toothList(Model model) {
        model.addAttribute("teeth", toothRepository.findAll());
        return "toothlist";
    }

    @PostMapping("/orderconfirmation")
    public String savemessage(Message msg) {
        messageRepository.save(msg);
        return "orderconfirmation";
    }

    @GetMapping("/requestTreatment")
    public String request(Model model) {
        model.addAttribute("tooth", new Tooth());
        model.addAttribute("teeth", toothRepository.findAll());
        model.addAttribute("message", new Message());
        return "requestTreatment";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/treatmentEdit")
    public String editTreatment(@RequestParam("pid") Long pid, Model model) {
        model.addAttribute("treatment", new Treatment());
        model.addAttribute("tooth", new Tooth());
        model.addAttribute("patient", patientRepository.findByPatientId(pid));
        model.addAttribute("teeth", toothRepository.findAll());
        model.addAttribute("toothinfo", "");
        return "treatmentEdit";
    }

    // @PreAuthorize("hasAuthority('ADMIN')")
    // @PostMapping("/savetreatment")
    // public String savetreatment(
    // @RequestParam("pid") Long pid,

    // @RequestParam("toothInfo") String toothinfo,
    // Treatment t) {

    // Patient savePatient = patientRepository.findByPatientId(pid);
    // // Tooth saveTooth = toothRepository.findByToothId(tid);
    // t.setPatient(savePatient);
    // // Treatment newTreatment = new Treatment(saveTooth, savePatient, toothinfo);
    // Tooth saveTooth = t.getTooth();

    // if (treatmentRepository.existsByToothAndPatient(saveTooth, savePatient)) {
    // return "toothRemoval";
    // } else {
    // treatmentRepository.save(t);

    // return "redirect:/admin_index";
    // }
    // }

}
