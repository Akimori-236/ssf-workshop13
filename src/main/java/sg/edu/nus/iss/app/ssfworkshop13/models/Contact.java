package sg.edu.nus.iss.app.ssfworkshop13.models;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Contact {
    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 64, message = "Name must be between 3 to 64 characters")
    private String name;
    
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email must be valid")
    private String email;

    @Size(min = 7, message = "Phone number must be at least 7 numbers")
    private String phoneNumber;

    @Past(message = "Are you from the future?")
    @NotNull(message = "Date of birth cannot be null")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate dob;

    private String id;

    // CONSTRUCTORS
    public Contact() {
        this.id = generateID(8);
    }

    public Contact(String id, String name, String email, String phoneNumber, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public Contact(String name, String email, String phoneNumber) {
        this.id = generateID(8);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // synchronized = one call at a time (blocking / queuing system) single thread
    // avoid duplication
    public synchronized String generateID(int numOfChar) {
        Random rnd = new Random();
        StringBuilder strBuilder = new StringBuilder();
        while (strBuilder.length() < numOfChar) {
            strBuilder.append(Integer.toHexString(rnd.nextInt()));
        }
        return strBuilder.toString().substring(0, numOfChar);
    }

}
