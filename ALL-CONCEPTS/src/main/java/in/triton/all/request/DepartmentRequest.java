package in.triton.all.request;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DepartmentRequest {

	@NotNull
	private String name;
	
	
}
