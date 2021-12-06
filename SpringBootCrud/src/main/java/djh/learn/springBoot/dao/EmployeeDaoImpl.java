package djh.learn.springBoot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import djh.learn.springBoot.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private EntityManager em;
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		Query<Employee> query = session.createQuery("from Employee",Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public Employee findById(int employeeId) {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
	//	Query query =  session.createQuery("from Employee where id=:employeeId",Employee.class);
	//	query.setParameter("employeeId",employeeId);
		Employee empl = session.get(Employee.class, employeeId);
	//	Employee emp = (Employee) query.getSingleResult();
		return empl;
	}

	@Override
	@Transactional
	public void deleteById(int employeeId) {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		Query query =  session.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId",employeeId);
		query.executeUpdate();
	}

	@Override
	@Transactional
	public Employee insert(Employee employee) {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		 session.saveOrUpdate(employee);
		return employee;
	}

	@Override
	@Transactional
	public Employee update(Employee employee) {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		session.saveOrUpdate(employee);
		return employee;
	}

}
