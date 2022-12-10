package in.triton.all.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.triton.all.api.response.ApiResponse;
import in.triton.all.entity.Course;
import in.triton.all.entity.CourseStudent;
import in.triton.all.entity.Student;
import in.triton.all.request.CourseRequest;
import in.triton.all.request.StudentRequest;
import in.triton.all.request.StudentSetCourseRequest;
import in.triton.all.response.CourseResponse;
import in.triton.all.service.IStudentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
	
	@Autowired
	IStudentService StudentService;

	@PostMapping("/")
	public ResponseEntity<ApiResponse> saveAll(@Valid @RequestBody StudentRequest studentRequest )  {
		ApiResponse apiResponse = StudentService.saveAll(studentRequest);
		return ResponseEntity.ok(apiResponse);
	}
	
	@GetMapping("/")
	public ResponseEntity<ApiResponse> getAll() throws ClassNotFoundException{
		ApiResponse apiResponse = StudentService.getAll();
		return ResponseEntity.ok(apiResponse);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse> getOne(@PathVariable("id") int id) throws ClassNotFoundException{
		ApiResponse apiResponse = StudentService.getOne(id);
		return ResponseEntity.ok(apiResponse);	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse> update(@Valid @RequestBody StudentRequest studentRequest,@PathVariable("id") int id){
		ApiResponse apiResponse = StudentService.update(studentRequest,id);
		return ResponseEntity.ok(apiResponse);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteOne(@PathVariable("id")int id){
		ApiResponse apiResponse =StudentService.delete(id);
		return ResponseEntity.ok(apiResponse);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<ApiResponse> deleteAll(){
		ApiResponse apiResponse =StudentService.deleteAll();
		return ResponseEntity.ok(apiResponse);
	}
	
	
	@PostMapping("/{id}/setCourse")
	public ResponseEntity<ApiResponse> saveCourse(@Valid @RequestBody List<StudentSetCourseRequest>  studentSetCourseRequests , @PathVariable("id") int id )  {
		ApiResponse apiResponse = StudentService.saveAll(studentSetCourseRequests,id);
		return ResponseEntity.ok(apiResponse);
	}
}
