package in.triton.all.service;

import in.triton.all.api.response.ApiResponse;
import in.triton.all.exception.ResourceAlreadyExists;
import in.triton.all.request.DepartmentRequest;

public interface IDepartmentService {
	
	public ApiResponse saveAll(DepartmentRequest departmentRequest) throws ResourceAlreadyExists;

	public ApiResponse getAll() throws ClassNotFoundException;
	
	public ApiResponse update(DepartmentRequest departmentRequest,int id);

	public ApiResponse delete(int id);

	public ApiResponse getOne(int id);

	public ApiResponse deleteAll();

}
