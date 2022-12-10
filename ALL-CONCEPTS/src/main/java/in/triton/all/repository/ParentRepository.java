package in.triton.all.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.triton.all.entity.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> {

}
