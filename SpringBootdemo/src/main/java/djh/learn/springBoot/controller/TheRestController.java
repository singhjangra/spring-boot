package djh.learn.springBoot.controller;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheRestController {

	@Value(value = "${coach.name}")
	private String coachName;
	
	@Value(value = "${team.name}")
	private String teamName;
	
	@GetMapping("/")
	public String hello() {
		return "hello welcome to spring boot "+LocalTime.now();
	}
	

	@GetMapping("/teamInfo")
	public String teamInfo() {
		System.out.println(coachName+"----------"+teamName);
		return coachName+"----------"+teamName;
	}
}
