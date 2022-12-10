package in.triton.all.mapping;

import java.util.List;

import org.springframework.stereotype.Component;

import in.triton.all.entity.Course;
import in.triton.all.entity.Department;
import in.triton.all.entity.Parent;
import in.triton.all.entity.Student;
import in.triton.all.request.CourseRequest;
import in.triton.all.request.StudentRequest;
import jakarta.validation.Valid;

@Component
public class StudentRequestMapper {

	public Student modelToEntity(StudentRequest studentRequest, Department department) {
		Student student = new Student();
		student.setName(studentRequest.getName());
		student.setDob(studentRequest.getDob());
		student.setDepartment(department);

		Parent parent = studentRequest.getParent();
		parent.setName(parent.getName());
		parent.setPhoneNumber(parent.getPhoneNumber());
		parent.setStudent(student);

		student.setParent(parent);

		return student;
	}

	public Student modelToEntitys(@Valid StudentRequest studentRequest, Department department,int id) {

		Student student = new Student();
		student.setStudentId(id);
		student.setName(studentRequest.getName());
		student.setDob(studentRequest.getDob());
		student.setDepartment(department);

		Parent parent = studentRequest.getParent();
		parent.setName(parent.getName());
		parent.setPhoneNumber(parent.getPhoneNumber());
		parent.setStudent(student);

		student.setParent(parent);

		return student;
	}

	public Student modelToEntity(@Valid CourseRequest courseRequest, Student student) {
		
	  List<Course> courses	= courseRequest.getCourses();
	  student.setCourse(courses);	  
	  return student;
	}

}
