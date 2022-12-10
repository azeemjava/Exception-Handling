package in.triton.all.request;

import in.triton.all.entity.Parent;
import lombok.Data;

@Data
public class StudentRequest {

	private String name;
	private String dob;
	private int departmentId;
	private Parent parent;
		
}
