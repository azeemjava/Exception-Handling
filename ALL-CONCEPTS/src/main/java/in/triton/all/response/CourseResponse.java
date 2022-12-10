package in.triton.all.response;

import java.util.List;

import in.triton.all.entity.Course;
import lombok.Data;

@Data
public class CourseResponse {

	List<Course> courses;
	
}
