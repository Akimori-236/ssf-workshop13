package sg.edu.nus.iss.app.ssfworkshop13.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull; // @ NonNull = NULL SAFETY FEATURE

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Person {
    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 64, message = "Name must be between 3 to 64 characters")
    private String name;

    @Email(message = "Email must be valid")
    private String email;

    @Min(value = 10, message = "Age cannot be less than 10 years old")
    @Max(value = 100, message = "Age cannot be more than 100 years old")
    private Integer age;

    // @NotNull(message = "Phone number cannot be null")
    // @Size(min = 7, max = 8, message = "Phone number must be between 7 to 8
    // numbers")
    // // @NumberFormat
    // private int phoneNum;

    @Past(message = "Are you from the future?")
    @NotNull(message = "Date of birth cannot be null")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate dob;

    private Boolean isMarried;

    @NotEmpty(message = "Hobbies cannot be empty")
    @Size(min = 1, message = "Must be at least one hobby")
    private List<String> hobbies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // public int getPhoneNum() {
    // return phoneNum;
    // }

    // public void setPhoneNum(int phoneNum) {
    // this.phoneNum = phoneNum;
    // }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Boolean getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(Boolean isMarried) {
        this.isMarried = isMarried;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    // generate random hex string
    // public static String generateHexStr() {
    // String hexStr;
    // Random r = new Random();
    // int i = r.nextInt();
    // hexStr = Integer.toHexString(i).toUpperCase();
    // hexStr = hexStr.substring(0, 8);
    // return hexStr;
    // }
}
