package Lab24.hammaslaakari.web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
import Lab24.hammaslaakari.model.Patient;
import Lab24.hammaslaakari.model.PatientRepository;
import Lab24.hammaslaakari.model.Tooth;
import Lab24.hammaslaakari.model.ToothRepository;
import Lab24.hammaslaakari.model.Treatment;
import Lab24.hammaslaakari.model.TreatmentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ToothController {

    @Autowired
    private ToothRepository toothRepository;

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private TreatmentRepository treatmentRepository;

    private static final Logger logger = LoggerFactory.getLogger(ToothController.class);

    // @GetMapping("/admin_index")
    // public String indexPage(Model model) {
    // model.addAttribute("patients", patientRepository.findAll());
    // return "admin_index";
    // }

    @GetMapping("/user_index")
    public String userIndexPage(Model model) {
        // model.addAttribute("tooth", new Tooth());
        model.addAttribute("teeth", toothRepository.findAll());
        return "user_index";
    }

    @GetMapping("/toothlist")
    public String toothList(Model model) {
        model.addAttribute("teeth", toothRepository.findAll());
        return "toothlist";
    }

    @GetMapping("/orderconfirmation")
    public String confirmation(Model model) {
        return "orderconfirmation";
    }

    @GetMapping("/requestTreatment")
    public String request(Model model) {
        model.addAttribute("tooth", new Tooth());
        model.addAttribute("teeth", toothRepository.findAll());
        return "requestTreatment";
    }

    // ChatGPT:n avulla luotu admin_index 9.4.2024 klo 10:35. Jouduin käymään
    // ChatGPT:n kanssa pitkän keskustelun ja yritin muokata kohdesivun thymeleafia
    // monta kertaa.
    // Käytin mm. #list ja #set -muuttujia, joita thymeleaf ei kuitenkaan
    // tunnistanut. En tiedä, kuuluuko ne importoida erikseen (en osannut tehdä
    // tätä, enkä saanut siihen neuvoja mistään.)
    // Yritin myös lukea StackOverflow:ta, mutta vastaavaan ongelmaan ei ollut
    // löytynyt yksinkertaista apua. Ehkä en osannut etsiä oikealla hakusanalla.
    // Tietoa etsitty 8.4. ja 9.4.

    @GetMapping("/admin_index")
    public String indexPage(Model model) {
        // Retrieve all treatments from the repository
        List<Treatment> treatments = (List<Treatment>) treatmentRepository.findAll();

        // Create a set to hold distinct patient IDs
        Set<Long> distinctPatientIds = new HashSet<>();

        // Create a list to hold filtered treatments
        List<Treatment> filteredTreatments = new ArrayList<>();

        // Iterate over treatments and filter by distinct patient IDs
        for (Treatment treatment : treatments) {
            // If the patient ID is not in the set, add the treatment to filteredTreatments
            if (!distinctPatientIds.contains(treatment.getPatient().getPatientId())) {
                filteredTreatments.add(treatment);
                // Add the patient ID to the set to mark it as seen
                distinctPatientIds.add(treatment.getPatient().getPatientId());
            }
        }

        // Add the filtered treatments to the model
        model.addAttribute("treatments", filteredTreatments);

        // Return the name of the Thymeleaf template
        return "admin_index";
    }

    /*
     * --------->>>
     * Alkuperäinen @GetMapping("admin_index")
     * Muokattu monta kertaa ohjeiden mukaan ilman toivottua tulosta.
     * Yritetty useaan kertaan luoda listan filtteröintiä (nimi esiintyy vain
     * kerran) thymeleafissa siinä onnistumatta.
     * 
     * @GetMapping("/admin_index")
     * public String indexPage(Model model) {
     * 
     * // List<Treatment> treatments = (List<Treatment>)
     * treatmentRepository.findAll();
     * // Set<Long> distinctPatients = new HashSet<>();
     * 
     * // for (Treatment t : treatments) {
     * // if (!distinctPatients.contains(t.getPatient().getPatientId())) {
     * // distinctPatients.add(t.getPatient().getPatientId());
     * // }
     * // }
     * 
     * // model.addAttribute("treatments", distinctPatients);
     * model.addAttribute("treatments", treatmentRepository.findAll());
     * model.addAttribute("treatment", new Treatment());
     * return "admin_index";
     * }
     */

    @GetMapping("/treatmentEdit")
    public String editTreatment(@RequestParam("pid") Long pid, Model model) {
        model.addAttribute("treatment", new Treatment());
        model.addAttribute("tooth", new Tooth());
        model.addAttribute("patient", patientRepository.findByPatientId(pid));
        model.addAttribute("teeth", toothRepository.findAll());
        return "treatmentEdit";
    }

    // public boolean toothTreated(Long toothId, Long patientId) {
    // boolean treatmentDone = treatmentRepository.existsByToothAndPatient(toothId,
    // patientId);
    // return treatmentDone;

    // }

    @PostMapping("/savetreatment")
    public String savetreatment(@RequestParam("pid") Long pid, @RequestParam("chosenTooth") Long chosenTooth,
            @ModelAttribute("treatment") Treatment t) {

        logger.info("Incoming request parameters: pid={}, chosenTooth={}", pid, chosenTooth);
        Patient p = patientRepository.findByPatientId(pid);
        t.setPatient(p);
        Tooth tooth = toothRepository.findByToothId(chosenTooth);
        t.setTooth(tooth);

        if (treatmentRepository.existsByToothAndPatient(tooth, p)) {
            return "user_index"; // ihan vain testin vuoksi (oikeasti pitäisi olla joku error-sivu)
        } else {
            treatmentRepository.save(t);
            return "redirect:/admin_index";
        }

        // if (toothTreated(chosenTooth, pid)) {
        // return "user_index";
        // } else {
        // treatmentRepository.save(t);
        // return "redirect:/admin_index";
    }
}

// @PostMapping("/treatment")
// public String addTreatment(Tooth tooth) {
// toothRepository.save(tooth);
// return "treatment";
// }

/*
 * 
 * @PreAuthorize("hasAuthority('ADMIN')")
 * 
 *
 * 
 * @PreAuthorize("hasAuthority('ADMIN')")
 * 
 * 
 * 
 * @PreAuthorize("hasAuthority('ADMIN')")
 * 
 * @GetMapping("/editBook/{id}")
 * public String editBook(@PathVariable("id") Long id, Model model) {
 * model.addAttribute("book", repository.findById(id));
 * model.addAttribute("categories", cRepository.findAll());
 * return "editBook";
 * }
 * 
 * @PreAuthorize("hasAuthority('ADMIN')")
 * 
 * @GetMapping("/delete/{id}")
 * public String deleteBook(@PathVariable("id") Long id, Model model) {
 * System.out.println("delete book " + id);
 * repository.deleteById(id);
 * return "redirect:/booklist";
 * }
 * 
 */
