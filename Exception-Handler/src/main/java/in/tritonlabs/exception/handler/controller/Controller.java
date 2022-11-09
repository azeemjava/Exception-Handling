package in.tritonlabs.exception.handler.controller;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/exception")
public class Controller {

	@PostMapping("/{id}")
	public void get(@PathVariable("id") int id) {

		if (id == 1) {

			throw new IllegalArgumentException();

		} else if (id == 2) {

			throw new IllegalAccessError();

		} else {

			throw new IllegalCallerException();

		}

	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String handler1() {

		return "This is 1";

	}

	@ExceptionHandler(value = { IllegalCallerException.class })
	public String handler2(IllegalCallerException c) {

		return "This is out of number";

	}

}
