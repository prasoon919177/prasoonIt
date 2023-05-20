package in.git.MiniProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrasoonController {

	@GetMapping("/pr")
	String meth1(@RequestParam String name){
		return "Hello "+name;
	}
}
