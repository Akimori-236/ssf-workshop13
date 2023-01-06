package sg.edu.nus.iss.app.ssfworkshop13.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class IOUtil {
    public static String dataDir;
    public static String errMsg = "Please use --dataDir=... to set data directory of the Address book";

    public static void createDir(String filepath) {
        File dir = new File(filepath);
        // Files.createDirectory(dir); ?
        boolean isCreated = dir.mkdir();

        if (isCreated) {
            String osname = System.getProperty("os.name");
            if (!osname.contains("Windows")) {
                // Windows folder creation - will have default permission when the folder is created
                // if OS is not Windows, linux and mac dont allow for folder creation - Access Permission Denied
                try {
                    // permission annotation
                    String perm = "rwxrwx---";
                    Set<PosixFilePermission> permissions = PosixFilePermissions.fromString(perm);
                    // set permissions for folder
                    Files.setPosixFilePermissions(dir.toPath(), permissions);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }

    public static void createFile() {
        
    }
}
