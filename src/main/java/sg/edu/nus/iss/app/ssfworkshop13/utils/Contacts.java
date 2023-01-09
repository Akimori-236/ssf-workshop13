package sg.edu.nus.iss.app.ssfworkshop13.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;

import sg.edu.nus.iss.app.ssfworkshop13.models.Contact;

@Component("contacts")
public class Contacts {

    // write the file
    public void saveContact(Contact contact, Model model, ApplicationArguments appArgs, String defaultDataDir) {
        // contact hex id generator
        String dataFilename = contact.getId();
        PrintWriter pw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(getDataDir(appArgs, defaultDataDir) + "/" + dataFilename);
            pw = new PrintWriter(fw);
            pw.println(contact.getName());
            pw.println(contact.getEmail());
            pw.println(contact.getPhoneNumber());
            pw.println(contact.getDob().toString());

            pw.flush();
            pw.close();

            fw.flush();
            fw.close();
        } catch (IOException e) {
            // stack trace will slow down system in production
            System.err.println(e);
        }
    }

    // get arguments from the command line
    private String getDataDir(ApplicationArguments appArgs, String defaultDataDir) {
        String dataDirResult = null;
        List<String> optValues = null;

        // currently appArgs will have 1 key:value pair if user inputs cmd line argument
        // kind of appArgs.keyset()
        Set<String> opsNames = appArgs.getOptionNames();
        String[] optNamesArr = opsNames.toArray(new String[opsNames.size()]);

        // if there is a argument, get the value
        if (optNamesArr.length > 0) {
            // do we need to check the argument name???
            optValues = appArgs.getOptionValues(optNamesArr[0]);
            // optValuesArr = optValues.toArray(new String[optValues.size()]);
            dataDirResult = optValues.get(0);
        } else {
            dataDirResult = defaultDataDir;
        }

        return dataDirResult;
    }

    // read the file
    public void getContactByID(Model model, String contactID, ApplicationArguments appArgs, String defaultDataDir) {
        Contact c = new Contact();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        Path filepath = new File(getDataDir(appArgs, defaultDataDir) + "/" + contactID).toPath();
        // loading charset (retrieving need UTF but saving dont need UTF)
        Charset charset = Charset.forName("UTF-8");
        try {
            // read all the lines in the file with UTF-8
            List<String> dataLines = Files.readAllLines(filepath, charset);

            // setting attributes into the created Contact object c
            // same order as how we saved the file
            c.setId(contactID);
            c.setName(dataLines.get(0));
            c.setEmail(dataLines.get(1));
            c.setPhoneNumber(dataLines.get(2));
            // convert String to LocalDate
            // formatter affects the appearance of the date
            LocalDate dob = LocalDate.parse(dataLines.get(3), formatter);
            c.setDob(dob);
        } catch (IOException e) {
            System.err.println(e);
            // send error code
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact info not found");
        }
        // send c to page view
        model.addAttribute("contact", c);
    }
}
