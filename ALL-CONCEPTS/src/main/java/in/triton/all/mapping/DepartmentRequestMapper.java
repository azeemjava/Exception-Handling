package in.triton.all.mapping;

import org.springframework.stereotype.Component;
import in.triton.all.entity.Department;
import in.triton.all.request.DepartmentRequest;

@Component
public class DepartmentRequestMapper {

	public Department modelToEntity(DepartmentRequest departmentRequest) {
		Department department = new Department();
		department.setName(departmentRequest.getName());
		return department;
		
	}
	
	public Department modelToEntity(DepartmentRequest departmentRequest,int id) {
		
		Department department = new Department();
		department.setDepartmentId(id);
		department.setName(departmentRequest.getName());
		return department;
		
	}
	
}
