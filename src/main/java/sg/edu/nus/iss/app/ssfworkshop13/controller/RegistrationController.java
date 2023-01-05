package sg.edu.nus.iss.app.ssfworkshop13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.app.ssfworkshop13.models.Person;

@Controller
@RequestMapping(path = "/register")
public class RegistrationController {

    @GetMapping()
    public String getForm(Model model) {
        model.addAttribute("person", new Person());
        return "register";
    }

    @PostMapping()
    public String postRegistration(@Valid Person person, BindingResult binding, Model model) {
        if (binding.hasErrors()) {
            System.out.println(binding.getAllErrors().get(0).getDefaultMessage().toString());
            // model.addAttribute("person", person);
            return "register";
        }
        return "thankyou";
    }
}
