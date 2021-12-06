package djh.learn.springBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import djh.learn.springBoot.dao.EmployeeDao;
import djh.learn.springBoot.entity.Employee;
import djh.learn.springBoot.jpaRepository.EmployeeRespository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	/*
	 * @Autowired
	 * 
	 * @Qualifier("employeeJPADaoImpl") private EmployeeDao dao;
	 */
	@Autowired
	private EmployeeRespository respository;
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
	//	return dao.findAll();
		return respository.findAll();
	}

	@Override
	public Employee findById(int employeeId) {
		// TODO Auto-generated method stub
	//	return dao.findById(employeeId);
		return respository.findById(employeeId).orElse(null);
	}

	@Override
	public void deleteById(int employeeId) {
		// TODO Auto-generated method stub
		respository.deleteById(employeeId);
	//	dao.deleteById(employeeId);
	}

	@Override
	public Employee insert(Employee employee) {
		// TODO Auto-generated method stub
		return respository.save(employee);
		//return dao.insert(employee);
	}

	@Override
	public Employee update(Employee employee) {
		// TODO Auto-generated method stub
	//	return dao.update(employee);
		return respository.save(employee);
	}

}
