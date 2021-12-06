package djh.learn.springBoot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import djh.learn.springBoot.entity.Employee;
import djh.learn.springBoot.repo.CrudRepo;

@Controller
@RequestMapping("/employees")
public class CrudController {
	
	@Autowired
	private CrudRepo repo;
	/*
	 * List<Employee> emps ;
	 * 
	 * @PostConstruct public void loadData() { emps = new ArrayList(); emps.add(new
	 * Employee("deepak","jangra","deepak@gmail.com")); emps.add(new
	 * Employee("sunil","jangra","sunil@gmail.com")); emps.add(new
	 * Employee("ajay","jangra","ajay@gmail.com")); }
	 */
	@GetMapping("/")
	public String findAll(Model model){
		List<Employee> emps = repo.findAll();
	    model.addAttribute("list", emps);
	    System.out.println(emps);
		return "list";
	}
	
	@GetMapping("/showAddForm/{employeeId}")
	public String showAddForm(@PathVariable("employeeId")int employeeId, Model  model){
		Employee emp = new Employee();
		System.out.println("employeeId  "+employeeId);
	   
	    if(employeeId==0)
	    {
	    	 model.addAttribute("heading", "Add new Employee");	  
	    	 model.addAttribute("emp", emp);	  
	    }
	    else
	    {
	    	emp = repo.findById(employeeId).orElse(null);
	    	model.addAttribute("emp", emp);	  
	    	model.addAttribute("heading", "Update the Employee");	  
	    }
		return "edit";
	}
	
	@GetMapping("/{employeeId}")
	public String find(@PathVariable("employeeId")int employeeId,Model  model){
		Employee emp = repo.findById(employeeId).orElse(null);
	    model.addAttribute("emp", emp);
	    System.out.println(emp);
		return "employee";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("emp") Employee emp,Model  model){
		repo.save(emp);
		System.out.println(emp);
		return "redirect:/employees/";
	}
	
	@GetMapping("/delete/{employeeId}")
	public String delete(@PathVariable("employeeId")int employeeId){
		repo.deleteById(employeeId);
		System.out.println("Data deleted successfully...............");
		return "redirect:/employees/";
	}
}
