package in.triton.all.mapping;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import in.triton.all.entity.Course;
import in.triton.all.entity.CourseStudent;
import in.triton.all.request.CourseRequest;
import jakarta.validation.Valid;

@Component
public class CourseRequestMapper {

	public List<Course> modelToEntity(CourseRequest courseRequest) {
		
		List<Course> courses =courseRequest.getCourses();
System.out.println(courses.get(0).getName());
		
		return courses;
	}

	
	
	
	
	

}
