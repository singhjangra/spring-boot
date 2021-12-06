package djh.learn.springBoot.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import djh.learn.springBoot.entity.Employee;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee,Integer>{

}
