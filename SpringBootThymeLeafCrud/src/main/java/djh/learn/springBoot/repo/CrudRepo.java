package djh.learn.springBoot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import djh.learn.springBoot.entity.Employee;

@Repository
public interface CrudRepo extends JpaRepository<Employee,Integer>{

}
