package djh.learn.springBoot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import djh.learn.springBoot.entity.Employee;

@Controller
public class CrudController {
	
	List<Employee> emps ;
	@PostConstruct
	public void loadData() {
		emps = new ArrayList();
		emps.add(new Employee("deepak","jangra","deepak@gmail.com"));
		emps.add(new Employee("sunil","jangra","sunil@gmail.com"));
		emps.add(new Employee("ajay","jangra","ajay@gmail.com"));
	}
	@GetMapping("/list")
	public String findAll(Model model){
	    model.addAttribute("list", emps);
	    System.out.println(emps);
		return "list";
	}
}
