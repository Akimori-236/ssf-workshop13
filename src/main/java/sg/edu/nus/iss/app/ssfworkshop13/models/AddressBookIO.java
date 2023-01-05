package sg.edu.nus.iss.app.ssfworkshop13.models;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddressBookIO {
    public static void BookIO(String filename) {
        Path path = Paths.get(filename);
        File fileObj = path.toFile();
        // check directory
        if (fileObj.exists()) {
            System.out.println(":) Valid directory");
            // TODO: read file
        } else {
            // create directory if not found
            System.err.println(":( Directory not found... creating directory...");
            try {
                Files.createDirectory(path);
                System.out.println(":) Directory created");
            } catch (IOException e) {
                System.err.println(":( Unable to create directory. Error ->" + e.getMessage());
            }
        }
    }
}
