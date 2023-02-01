package SpringSql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ServletComponentScan
public class TravelBApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelBApplication.class, args);
	}

}
