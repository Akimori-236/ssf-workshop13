package sg.edu.nus.iss.app.ssfworkshop13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/contacts")
public class ContactsController {

    @GetMapping()
    public String getContacts(Model model) {
        return "contacts";
    }
}
