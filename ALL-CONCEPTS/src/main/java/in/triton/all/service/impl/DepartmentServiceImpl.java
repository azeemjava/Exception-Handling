package in.triton.all.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.triton.all.api.response.ApiResponse;
import in.triton.all.entity.Department;
import in.triton.all.exception.ResourceAlreadyExists;
import in.triton.all.exception.ResourceNotFound;
import in.triton.all.mapping.DepartmentRequestMapper;
import in.triton.all.mapping.DepartmentResponseMapper;
import in.triton.all.repository.DepartmentRepository;
import in.triton.all.request.DepartmentRequest;
import in.triton.all.response.DepartmentResponse;
import in.triton.all.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	DepartmentRequestMapper departmentRequestMapper;

	@Autowired
	DepartmentResponseMapper departmentResponseMapper;

	public ApiResponse saveAll(DepartmentRequest departmentRequest) throws ResourceAlreadyExists {

		Optional<Department> department = departmentRepository.findDepartmentByName(departmentRequest.getName());

		if (department.isPresent()) {
			throw new ResourceAlreadyExists("Resource Already Found");
		}

		Department departmentGet = departmentRequestMapper.modelToEntity(departmentRequest);
		departmentGet = departmentRepository.save(departmentGet);
		DepartmentResponse departmentResponse = departmentResponseMapper.entityToModel(departmentGet);
		ApiResponse apiResponse = new ApiResponse(departmentResponse, null, "SUCCESSFULL", 201);
		return apiResponse;
	}

	public ApiResponse getAll() throws ClassNotFoundException {
		List<Department> department = departmentRepository.findAll();
		List<DepartmentResponse> departments = departmentResponseMapper.entityToModel(department);
		ApiResponse apiResponse = new ApiResponse(departments, null, "SUCCESSFULL", 200);
		return apiResponse;
	}

	public ApiResponse update(DepartmentRequest departmentRequest, int id) {

		Optional<Department> department = departmentRepository.findById(id);
		if (department.isEmpty()) {
			throw new ResourceNotFound(id + " This Resource Not Found");
		}
		Department departmentSet = departmentRequestMapper.modelToEntity(departmentRequest, id);
		departmentSet = departmentRepository.save(departmentSet);
		DepartmentResponse departmentResponse = departmentResponseMapper.entityToModel(departmentSet);
		ApiResponse apiResponse = new ApiResponse(departmentResponse, null, "SUCCESSFULL", 200);
		return apiResponse;
	}

	public ApiResponse delete(int id) {
		Optional<Department> department = departmentRepository.findById(id);
		if (department.isEmpty()) {
			throw new ResourceNotFound(id + " This Resource Not Found");
		}
		departmentRepository.deleteById(id);
		ApiResponse apiResponse = new ApiResponse(id + " Deleted", null, "SUCCESSFULL", 200);
		return apiResponse;

	}

	public ApiResponse getOne(int id) {
		Optional<Department> department = departmentRepository.findById(id);
		if (department.isEmpty()) {
			throw new ResourceNotFound(id + " This Resource Not Found");
		}
		DepartmentResponse departmentResponse = departmentResponseMapper.entityToModel(department);
		ApiResponse apiResponse = new ApiResponse(departmentResponse, null, "SUCCESSFULL", 200);
		return apiResponse;
	}

	public ApiResponse deleteAll() {		
		departmentRepository.deleteAll();
		ApiResponse apiResponse = new ApiResponse(" Deleted All", null, "SUCCESSFULL", 200);
		return apiResponse;
	}
}