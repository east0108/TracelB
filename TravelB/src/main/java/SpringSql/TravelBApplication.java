package SpringSql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"SpringSql.repository","SpringSql.controller","SpringSql.dao","SpringSql.dto","SpringSql.model","SpringSql.rowmapper","SpringSql.service"})
public class TravelBApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelBApplication.class, args);
	}

}
