package sg.edu.nus.iss.app.ssfworkshop13.models;

import java.util.Random;

public class Contacts {
    
    // generate random hex string
    public static String generateHexStr() {
        String hexStr;
        Random r = new Random();
        int i = r.nextInt();
        hexStr = Integer.toHexString(i).toUpperCase();
        hexStr = hexStr.substring(0, 8);
        return hexStr;
    }

}
