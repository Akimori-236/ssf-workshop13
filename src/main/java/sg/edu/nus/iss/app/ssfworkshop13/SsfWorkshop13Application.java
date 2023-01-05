package sg.edu.nus.iss.app.ssfworkshop13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SsfWorkshop13Application {

	// private static final Logger logger = LoggerFactory.getLogger(SsfWorkshop13Application.class);
	// private static String dataDir;
	// private static String errMsg = "Please use --dataDir=... to set data directory of the Address book";

	public static void main(String[] args) {
		// for (String argVal : args) {
		// 	logger.debug("argVal -> " + argVal);
		// 	// check for --dataDir
		// 	if (argVal.contains("--dataDir")) {
		// 		dataDir = argVal.replace("--dataDir=", "");
		// 		logger.debug("Data Directory -> " + dataDir);
		// 		// call the addressbook IO
		// 		AddressBookIO.BookIO(dataDir);
		// 	} else {
		// 		// Error msg and exit if no --dataDir
		// 		logger.error(errMsg);
		// 		System.exit(1);
		// 	}
		// }
		SpringApplication.run(SsfWorkshop13Application.class, args);
		// SpringApplication app = new SpringApplication(SsfWorkshop13Application.class);
		// app.run(args);
	}

}
