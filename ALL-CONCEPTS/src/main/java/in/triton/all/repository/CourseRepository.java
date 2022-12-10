package in.triton.all.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.triton.all.entity.Course;
import in.triton.all.entity.Department;
import in.triton.all.request.CourseRequest;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	Optional<Department> findByName(CourseRequest courseRequest);

}
