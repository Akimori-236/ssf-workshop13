package sg.edu.nus.iss.app.ssfworkshop13.controller;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.app.ssfworkshop13.models.Contact;
import sg.edu.nus.iss.app.ssfworkshop13.utils.Contacts;

@Controller
@RequestMapping(path = "/addressbook")
public class AddressbookController {
    public static final String DEFAULT_DIR = "/opt/SSF/ssf-workshop13/data";

    @Autowired
    Contacts contacts;

    @Autowired
    ApplicationArguments appArgs;

    // SHOW FORM
    @GetMapping
    public String showAddressBook(Model model) {
        model.addAttribute("contact", new Contact());
        return "addressbook";
    }

    // FORM INPUT
    @PostMapping
    // validate contact object... import model to transport data to page
    public String saveContact(@Valid Contact contact, BindingResult binding, Model model) {
        // if @Valid validation fails
        if (binding.hasErrors()) {
            return "addressbook";
        }
        // custom age validation
        if (!isCorrectAge(contact.getDob())) {
            ObjectError error = new ObjectError("dob", "Age must be between 10 and 100 years old.");

            // tell springboot got error dont continue
            binding.addError(error);
            return "addressbook";
        }
        // autowired method
        contacts.saveContact(contact, model, appArgs, DEFAULT_DIR);
        return "result";
    }

    // AGE CHECKER
    private boolean isCorrectAge(LocalDate dob) {
        Integer calculatedAge;
        if (null != dob) {
            // get no of years from 'dob' to 'now()'
            calculatedAge = Period.between(dob, LocalDate.now()).getYears();
            if (calculatedAge >= 10 || calculatedAge <= 100) {
                return true;
            }
        }
        return false;
    }

    // GET CONTACT BY ID
    @GetMapping(path = "{contactID}")
    public String getContactByID(@PathVariable String contactID, Model model) {
        contacts.getContactByID(model, contactID, appArgs, DEFAULT_DIR);
        return "result";
    }

    @GetMapping(path="/list")
    public String getContactList(Model model) {
        contacts.getAllContacts(model, appArgs, DEFAULT_DIR);
        return "contactlist";
    }
}
