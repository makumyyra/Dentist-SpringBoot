package Lab24.hammaslaakari.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import Lab24.hammaslaakari.model.AppUserRepository;
import Lab24.hammaslaakari.model.Tooth;
import Lab24.hammaslaakari.model.ToothRepository;

@Controller
public class ToothController {

    @Autowired
    private ToothRepository toothRepository;

    @Autowired
    private AppUserRepository userRepository;

    @GetMapping("/index")
    public String indexPage(Model model) {
        // model.addAttribute("books", repository.findAll());
        return "index";
    }

    @GetMapping("/toothlist")
    public String toothList(Model model) {
        model.addAttribute("teeth", toothRepository.findAll());
        return "toothlist";
    }

    @GetMapping("/hurtform")
    public String addtoothPage(Model model) {
        model.addAttribute("tooth", new Tooth());
        model.addAttribute("teeth", toothRepository.findAll());
        return "hurtForm";
    }

    @GetMapping("/orderconfirmation")
    public String confirmation(Model model) {
        return "orderconfirmation";
    }

    @PostMapping("/savetooth")
    public String savetooth(Tooth tooth) {
        toothRepository.save(tooth);
        return "treatment";
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
