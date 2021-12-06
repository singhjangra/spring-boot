package djh.learn.springBoot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import djh.learn.springBoot.entity.Employee;

@Repository
public class EmployeeJPADaoImpl implements EmployeeDao{

	@Autowired
	private EntityManager em;
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		TypedQuery query = em.createQuery("from Employee",Employee.class);		
		List<Employee> list = query.getResultList();
		return list;
	}
	
	@Override
	public Employee findById(int employeeId) {
		// TODO Auto-generated method stub
		Employee  empl = em.find(Employee.class, employeeId);
		return empl;
	}

	@Override
	@Transactional
	public void deleteById(int employeeId) {
		// TODO Auto-generated method stub
		Query query =  (Query) em.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId",employeeId);
		query.executeUpdate();
	}

	@Override
	@Transactional
	public Employee insert(Employee employee) {
		// TODO Auto-generated method stub
		Employee emp = em.merge(employee);
		return emp;
	}

	@Override
	@Transactional
	public Employee update(Employee employee) {
		// TODO Auto-generated method stub
		Employee emp = em.merge(employee);
		return emp;
	}

}
