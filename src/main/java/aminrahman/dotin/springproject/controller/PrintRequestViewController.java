package aminrahman.dotin.springproject.controller;

import aminrahman.dotin.springproject.aspect.ExecuteTime;
import aminrahman.dotin.springproject.entity.PrintRequest;
import aminrahman.dotin.springproject.service.PrintRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/view")
public class PrintRequestViewController {

    private final PrintRequestService service;

    public PrintRequestViewController(@Autowired PrintRequestService service) {
        this.service = service;
    }

    @GetMapping("/all-requests")
    @ExecuteTime
    public String showAllPrintRequests(Model model) {
        model.addAttribute("prints", service.getAll());
        return "all-requests";
    }

    @GetMapping("/request")
    public String showSavedRequest() {
        return "show-request";
    }

    @GetMapping("/add")
    @ExecuteTime
    public String addPrintRequestView(Model model) {
        model.addAttribute("print", new PrintRequest());
        return "add-request";
    }

    @PostMapping("/add")
    @ExecuteTime
    public RedirectView addPrintRequest(@ModelAttribute("print") PrintRequest printRequest, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/view/request", true);
        PrintRequest savedPrintRequest = service.saveRecord(printRequest);
        redirectAttributes.addFlashAttribute("savedRequest", savedPrintRequest);
        redirectAttributes.addFlashAttribute("addSuccess", true);
        return redirectView;

    }

}
