package in.triton.all.controller;

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
import in.triton.all.exception.ResourceAlreadyExists;
import in.triton.all.request.DepartmentRequest;
import in.triton.all.service.IDepartmentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentController {

	@Autowired
	IDepartmentService departmentService;

	@PostMapping("/")
	public ResponseEntity<ApiResponse> saveAll(@Valid @RequestBody DepartmentRequest departmentRequest) throws ResourceAlreadyExists {
		ApiResponse apiResponse = departmentService.saveAll(departmentRequest);
		return ResponseEntity.ok(apiResponse);
	}
	
	@GetMapping("/")
	public ResponseEntity<ApiResponse> getAll() throws ClassNotFoundException{
		ApiResponse apiResponse = departmentService.getAll();
		return ResponseEntity.ok(apiResponse);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse> getOne(@PathVariable("id") int id) throws ClassNotFoundException{
		ApiResponse apiResponse = departmentService.getOne(id);
		return ResponseEntity.ok(apiResponse);	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse> update(@Valid @RequestBody DepartmentRequest departmentRequest,@PathVariable("id") int id){
		ApiResponse apiResponse = departmentService.update(departmentRequest,id);
		return ResponseEntity.ok(apiResponse);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteOne(@PathVariable("id")int id){
		ApiResponse apiResponse =departmentService.delete(id);
		return ResponseEntity.ok(apiResponse);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<ApiResponse> deleteAll(){
		ApiResponse apiResponse =departmentService.deleteAll();
		return ResponseEntity.ok(apiResponse);
	}
	
	
}
