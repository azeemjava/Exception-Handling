package in.triton.all.entity;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@DynamicUpdate
@Table(name="parent")
@JsonInclude(value = Include.NON_NULL)
public class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="parent_id")
	private int parentId;
	
	@Column(nullable = false)
	private String name;
	
	@Length(min = 10,max = 10)
	@Column(name="phone_number")
	private String phoneNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_id")
	private Student student;
	
}
