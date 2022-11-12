package in.tirtonlabs.exeption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.tirtonlabs.exeption.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
