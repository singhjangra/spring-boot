package djh.learn.springBoot.service;

import java.util.List;

import djh.learn.springBoot.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int employeeId);

	public void deleteById(int employeeId);

	public Employee insert(Employee employee);

	public Employee update(Employee employee);
}
