package in.triton.all.mapping;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import in.triton.all.entity.Department;
import in.triton.all.response.DepartmentResponse;

@Component
public class DepartmentResponseMapper {

	public DepartmentResponse entityToModel(Department department) {

		DepartmentResponse departmentResponse = new DepartmentResponse();
		departmentResponse.setName(department.getName());
		departmentResponse.setId(department.getDepartmentId());
		return departmentResponse;

	}

	public List<DepartmentResponse> entityToModel(List<Department> departments) {

		return departments.stream().map(department -> entityToModel(department)).toList();

	}

	public DepartmentResponse entityToModel(Optional<Department> DepartmentResponse) {
		Department department = DepartmentResponse.get();
		DepartmentResponse departmentResponse = new DepartmentResponse();
		departmentResponse.setId(department.getDepartmentId());
		departmentResponse.setName(department.getName());
		return departmentResponse;
	}

}
