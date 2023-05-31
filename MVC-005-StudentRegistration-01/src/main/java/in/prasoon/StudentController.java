package in.prasoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import in.prasoon.binding.*;
import in.prasoon.entity.StudentEntity1;
import in.prasoon.repository.StudentRepository1;

@Controller
public class StudentController
{
	@Autowired
	private StudentRepository1 repo;
	
	//method to load student form
	@GetMapping("/")
	public String loadForm(Model model)//model is a map which is used to store the data in the form of Key and Value
	{									//model is used to send the data from controller to ui
		loadFromData(model);
		
		return "index";
	}
	
	//method to save student form data
	
	@PostMapping("/save")
	public String handleSubmit(Student1 s, Model model)
	{
		System.out.println(s);
		
		StudentEntity1 entity = new StudentEntity1();
		
		
		//copy data from binding obj to entity obj
		BeanUtils.copyProperties(s, entity);
		
		entity.setTimings(Arrays.toString(s.getTimings()));
		repo.save(entity);
		
		model.addAttribute("msg", "Student Saved");
		
		loadFromData(model);
		return "index";
	}

	private void loadFromData(Model model) {
		ArrayList<String> courseList = new ArrayList<>();
		courseList.add("Java");
		courseList.add("Spring");
		courseList.add("python");
		courseList.add("C++");
		courseList.add("HTML");
		
		ArrayList<String> timingList = new ArrayList<>();
		timingList.add("Morning");
		timingList.add("Afternoon");
		timingList.add("Evening");
		
		Student1 student=new Student1();
		model.addAttribute("courses", courseList);
		model.addAttribute("timing", timingList);
		model.addAttribute("student", student);
	}
	
	//method to display saved students data
	
	@GetMapping("/viewsStudents")
	public String getStudentData(Model model)
	{
		
		List<StudentEntity1> studentsList = repo.findAll();
		model.addAttribute("students", studentsList);//to send data to ui
		return "data";
	}
}
