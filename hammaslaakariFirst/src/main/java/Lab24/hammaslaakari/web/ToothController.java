package Lab24.hammaslaakari.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/admin_index")
    public String indexPage(Model model) {
        model.addAttribute("treatments", treatmentRepository.findAll());
        return "admin_index";
    }

    @GetMapping("/treatmentEdit")
    public String editTreatment(@RequestParam("pid") Long pid, @RequestParam("pname") String pname, Model model) {
        model.addAttribute("treatment", new Treatment());
        model.addAttribute("tooth", new Tooth());
        model.addAttribute("patient", new Patient(pid, pname));
        model.addAttribute("teeth", toothRepository.findAll());
        return "treatmentEdit";
    }

    @PostMapping("/savetreatment")
    public String savetreatment(Treatment t) {
        treatmentRepository.save(t);
        return "redirect:/admin_index";
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

}
