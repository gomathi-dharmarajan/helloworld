package studentinfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Studentinitializer {
	private static final Logger log=LoggerFactory.getLogger(Studentinitializer.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
SpringApplication.run(Studentinitializer.class);
log.info("Started....");
	}

}
