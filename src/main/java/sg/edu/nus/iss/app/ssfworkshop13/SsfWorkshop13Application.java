package sg.edu.nus.iss.app.ssfworkshop13;

import java.util.List;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static sg.edu.nus.iss.app.ssfworkshop13.utils.IOUtil.*;

@SpringBootApplication
public class SsfWorkshop13Application {
	public static String errMsg = "Use mvn spring-boot:run -Dspring-boot.run.arguments=--dataDir=... to set data directory of the Address book";

	public static void main(String[] args) {
		// SpringApplication.run(SsfWorkshop13Application.class, args);
		SpringApplication app = new SpringApplication(SsfWorkshop13Application.class);
		// create spring arguments to make the cmdline arguments available for
		// springboot
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
		List<String> opsVal = appArgs.getOptionValues("dataDir");
		System.out.println("opsVal -> " + opsVal);
		if (null != opsVal) {
			// imported method from IOUtil to create directory
			createDir(opsVal.get(0));
		} else {
			System.err.println(errMsg);
			System.exit(1);
		}
		app.run(args);
	}

}
