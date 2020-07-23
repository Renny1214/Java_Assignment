package Java_Assignment.Java_Assignment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class JavaAssignmentApplication {
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(JavaAssignmentApplication.class);
	public static void main(String[] args) {
		logger.info("Application Started!");
		SpringApplication.run(JavaAssignmentApplication.class, args);
	}
}
