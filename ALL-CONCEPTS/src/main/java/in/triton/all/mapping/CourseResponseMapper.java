package in.triton.all.mapping;

import java.util.List;

import org.springframework.stereotype.Component;

import in.triton.all.entity.Course;
import in.triton.all.response.CourseResponse;

@Component
public class CourseResponseMapper {

	public CourseResponse entityToModel(List<Course> course) {

		CourseResponse courseResponse=new CourseResponse();
		courseResponse.setCourses(course);
		
		
		return courseResponse;
	}

}
