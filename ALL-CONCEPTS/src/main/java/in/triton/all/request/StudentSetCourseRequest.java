package in.triton.all.request;

import java.util.List;

import lombok.Data;

@Data
public class StudentSetCourseRequest {
	
	private int studentId;

	private int courseId;
	
}
