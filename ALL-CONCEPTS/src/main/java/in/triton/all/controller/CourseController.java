package in.triton.all.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.triton.all.api.response.ApiResponse;
import in.triton.all.exception.ResourceAlreadyExists;
import in.triton.all.request.CourseRequest;
import in.triton.all.request.DepartmentRequest;
import in.triton.all.service.impl.CourseServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {
	
	@Autowired
	CourseServiceImpl courseService;
	
	@PostMapping("/")
	public ResponseEntity<ApiResponse> saveAll( @RequestBody CourseRequest  courseRequest) throws ResourceAlreadyExists {
		ApiResponse apiResponse = courseService.saveAll(courseRequest);
		return ResponseEntity.ok(apiResponse);
	}
	
	@GetMapping("/")
	public ResponseEntity<ApiResponse> getAll() throws ClassNotFoundException{
		ApiResponse apiResponse = courseService.getAll();
		return ResponseEntity.ok(apiResponse);	
	}
}
