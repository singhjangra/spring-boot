package djh.learn.springBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import djh.learn.springBoot.entity.Employee;
import djh.learn.springBoot.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class CrudController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/")
	public List<Employee> emloyees(){
		List<Employee> list = service.findAll();
		System.out.println("list of employee "+list);
		return list;
	}
	
	@GetMapping("/{employeeId}")
	public Employee getEmloyee(@PathVariable("employeeId") int employeeId){
		Employee emp = service.findById(employeeId);
		if(emp==null)
		{
			throw new RuntimeException("No employee found with id "+employeeId);
		}
		System.out.println("employee is "+emp);
		return emp;
	}
	
	@PostMapping("/")
	public Employee insertEmployee(@RequestBody Employee employee){
		Employee emp = service.insert(employee);
		System.out.println("employee is saved "+emp);
		return emp;
	}
	
	@PutMapping("/")
	public Employee upDateEmployee(@RequestBody Employee employee){
		Employee emp = service.update(employee);
		System.out.println("employee is updated "+emp);
		return emp;
	}
	
	@DeleteMapping("/{employeeId}")
	public void deleteEmloyee(@PathVariable("employeeId") int employeeId){
		Employee emp = service.findById(employeeId);
		if(emp==null)
		{
			throw new RuntimeException("No employee found with id "+employeeId);
		}
		service.deleteById(employeeId);
		System.out.println("employee is deleted Successfully.......");
	}
}
