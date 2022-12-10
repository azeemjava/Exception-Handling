package in.triton.all.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.triton.all.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	Optional<Department> findDepartmentByName(String name);
	
}
