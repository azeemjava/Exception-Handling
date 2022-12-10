package in.triton.all.entity;

import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@DynamicUpdate
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="student_id")
	private int studentId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String dob;
	
	@OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
	private Parent parent;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	
	@ManyToMany(mappedBy = "student",cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Course> course;
	
}
