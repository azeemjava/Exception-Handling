package in.triton.all.entity;

import java.util.List;
import org.hibernate.annotations.DynamicUpdate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@DynamicUpdate
@Table(name="department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="department_id")
	private int departmentId;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "department")
    private List<Student> student;	
	
}
