package com.swaggerdocs.SwaggerDocs.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swaggerdocs.SwaggerDocs.Entity.Student;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Student", description="This is API testing doc for Student API")
@RequestMapping
@RestController
public class StudentController {
	
	
	
	
	
	private List<Student> students = new ArrayList();
	
	
	@Operation(summary="Get All Students list",description="Get all students",tags= {"Student","getall"})
	@ApiResponses({@ApiResponse(responseCode="200",content= { @Content(schema=@Schema(implementation=Student.class),mediaType="application/json")}),
			@ApiResponse(responseCode="404",content= { @Content(schema=@Schema())}),
			@ApiResponse(responseCode="500",content= { @Content(schema=@Schema())})
	})
	@GetMapping("/getall")
	public List<Student> getstudents()
	{
		
		Student stud1 = new Student();
		stud1.setId(1);
		stud1.setFullname("Mohamed Akram");
		
		Student stud2 = new Student();
		stud2.setId(2);
		stud2.setFullname("Javed Akram");
		students.add(stud1);
		students.add(stud2);
		
		return students;
		
		
	}
	
	@GetMapping("/getsingle/{id}")
	public Student getstudent(@PathVariable("id") long id)
	{
		
		Student stud1 = new Student();
		stud1.setId(1);
		stud1.setFullname("Mohamed Akram");
		
		Student stud2 = new Student();
		stud2.setId(2);
		stud2.setFullname("Javed Akram");
		students.add(stud1);
		students.add(stud2);
		
		return students.stream().filter(stud -> stud.getId()==id).findAny().get();
		
		
	}
	
	
	
	@PostMapping("/addstudent")
	public Student addstudent(@RequestBody Student stud)
	{
		return stud;
		
	
		
		
	}
	
	@PutMapping("/addstudent/{id}")
	public Student updatestudent(@RequestBody Student stud, @PathVariable("id") long id)
	{
		
		Student stud1 = new Student();
		stud1.setId(1);
		stud1.setFullname("Mohamed Akram");
		
		Student stud2 = new Student();
		stud2.setId(2);
		stud2.setFullname("Javed Akram");
		students.add(stud1);
		students.add(stud2);
		
		Student stud3 = students.stream().filter(stud4 -> stud4.getId()==id).findFirst().get();
	stud3.setId(stud.getId());
	stud3.setFullname(stud.getFullname());
	
	return stud3;
		
	}
	
	
	@DeleteMapping("/delete/{id})")
	public String deletestudent(@PathVariable("id") long id)
	{

		Student stud1 = new Student();
		stud1.setId(1);
		stud1.setFullname("Mohamed Akram");
		
		Student stud2 = new Student();
		stud2.setId(2);
		stud2.setFullname("Javed Akram");
		students.add(stud1);
		students.add(stud2);
		
		Student stud3 = students.stream().filter(stud4 -> stud4.getId()==id).findFirst().get();
		students.remove(stud3);
		
		return "Student deleted";
		
		
	}
}
