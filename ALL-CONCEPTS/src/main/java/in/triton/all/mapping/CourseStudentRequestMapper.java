package in.triton.all.mapping;

import java.util.List;
import org.springframework.stereotype.Component;
import in.triton.all.entity.CourseStudent;
import in.triton.all.request.StudentSetCourseRequest;
import jakarta.validation.Valid;

@Component
public class CourseStudentRequestMapper {

	public List<CourseStudent> modelToEntity(@Valid List<StudentSetCourseRequest> studentSetCourseRequests, int id) {
		
		StudentSetCourseRequest list = null;
		
		for(int a=0;a<studentSetCourseRequests.size();a++) {
		
			list=studentSetCourseRequests.get(a);

		}
		
        System.out.println(list.getCourseId());
        
        
		studentSetCourseRequests.stream().forEach(c -> c.setStudentId(id));
		
		
		
		return null;
		
		
	}
		


}