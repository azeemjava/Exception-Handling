package in.tirtonlabs.exeption.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.tirtonlabs.exeption.entity.Student;
import in.tirtonlabs.exeption.repository.IStudentRepository;

@RestController
@RequestMapping("api/v1/student")
public class ApiController {

	@Autowired
	IStudentRepository studentRepo;

	@GetMapping("/{id}")
	public Optional<Student> getOne(@PathVariable("id") int id) {
//
//		 if (studentRepo.existsById(id)) { return studentRepo.findById(id); } else {
//		 throw new NullPointerException("Student with id "+id+" not found"); }
//		 
		
		
		  Optional<Student> student = Optional.ofNullable(studentRepo.findById(id).orElseThrow(()->new
		  NullPointerException("Student with id "+id+" not found"))); return student;
		
	}

}
