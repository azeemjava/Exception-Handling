package in.triton.all.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.triton.all.entity.CourseStudent;

@Repository
public interface CourseStudentRepository extends JpaRepository<CourseStudent, Long> {

}
