package in.tritonlabs.exception.handler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("in.tritonlabs.exception.handler")
public class ExceptionHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionHandlerApplication.class, args);
		System.out.println("EXCEPTION START");
	}

}
