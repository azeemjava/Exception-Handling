package in.triton.all.entity;

import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@DynamicUpdate
@Table(name="course")
@JsonInclude(value = Include.NON_NULL)
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="course_student",
			joinColumns = {@JoinColumn(name="course_id")},
			inverseJoinColumns = {@JoinColumn(name="student_id")}
	)
	@JsonBackReference
	private List<Student>  student;
	
}
