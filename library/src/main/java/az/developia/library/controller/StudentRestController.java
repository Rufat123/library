package az.developia.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.library.dao.StudentDAO;
import az.developia.library.model.Student;

@RestController
@RequestMapping(path="/rest/students")
public class StudentRestController {
	
	@Autowired
	private StudentDAO studentDAO;

	@GetMapping
	public List<Student> findAll(){
		return studentDAO.findAll();
	}
	
	@GetMapping(path="/{id}")
	public Student findById(@PathVariable(name="id") Integer id){
		return studentDAO.findById(id).get();
	}
}
