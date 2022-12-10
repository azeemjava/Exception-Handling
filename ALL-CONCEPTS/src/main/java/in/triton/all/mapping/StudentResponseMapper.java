package in.triton.all.mapping;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

import in.triton.all.entity.Course;
import in.triton.all.entity.Parent;
import in.triton.all.entity.Student;
import in.triton.all.response.StudentResponse;

@Component
public class StudentResponseMapper {

	public StudentResponse entityToModel(Student student) {
		StudentResponse studentResponse =new StudentResponse();
		studentResponse.setStudentId(student.getStudentId());
		studentResponse.setName(student.getName());
		studentResponse.setDob(student.getDob());
    	studentResponse.setDepartmentId(student.getDepartment().getDepartmentId());
    	
    	Parent parent =student.getParent();
    	Parent parent0=new Parent();
    	parent0.setParentId(parent.getParentId());
    	parent0.setName(parent.getName());
    	parent0.setPhoneNumber(parent.getPhoneNumber());
    	studentResponse.setParent(parent0);
		return studentResponse;
	}

	public List<StudentResponse> entityToModel(List<Student> studentGet) {
		List<StudentResponse> StudentResponse = studentGet.stream().map(student -> entityToModel(student)).toList();
		return StudentResponse;
	}

	public StudentResponse entityToModel(Optional<Student> studentGet) {
		Student student=studentGet.get();
		StudentResponse studentResponse =new StudentResponse();
		studentResponse.setStudentId(student.getStudentId());
		studentResponse.setName(student.getName());
		studentResponse.setDob(student.getDob());
    	studentResponse.setDepartmentId(student.getDepartment().getDepartmentId());
    	
    	Parent parent =student.getParent();
    	Parent parent0=new Parent();
    	parent0.setParentId(parent.getParentId());
    	parent0.setName(parent.getName());
    	parent0.setPhoneNumber(parent.getPhoneNumber());
    	studentResponse.setParent(parent0);
		return studentResponse;
	}

	public StudentResponse entityToCourseSetModel(Student student) {
		
		List<Course> course= student.getCourse();
		
		StudentResponse studentResponse =new StudentResponse();
		studentResponse.setStudentId(student.getStudentId());
		studentResponse.setDepartmentId(student.getDepartment().getDepartmentId());
		studentResponse.setCourse(course);
		
		return studentResponse;
	}

}
