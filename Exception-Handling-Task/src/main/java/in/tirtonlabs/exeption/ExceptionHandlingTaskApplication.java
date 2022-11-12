package in.tirtonlabs.exeption;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("in.tirtonlabs.exeption.repository")
@EntityScan("in.tirtonlabs.exeption.entity")
public class ExceptionHandlingTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionHandlingTaskApplication.class, args);
	}

}
