package az.developia.library.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.library.dao.StudentDAO;
import az.developia.library.model.Student;



@Controller
@PreAuthorize(value="hasAuthority('list:student')")
public class StudentController {

	@Autowired
	private StudentDAO studentDAO;
	
	@GetMapping(path = "/students")
	public String showStudent(Model model) {
		List<Student> students=studentDAO.findAll();
		model.addAttribute("students", students);
		return "students";
	}
	
	@GetMapping(path = "/students/new")
	@PreAuthorize(value="hasAuthority('new:student')")
	public String openNewStudentPage(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("header", "Yeni Tələbə");
		return "new-student";
	}
	
	@PostMapping(path = "/students/new-student-process")
	@PreAuthorize(value="hasAuthority('save:student')")
	public String saveStudent(@Valid @ModelAttribute(name="student")Student student, 
			BindingResult result, Model model) {

		
		if (result.hasErrors()) {
			return "new-student";
		}
		studentDAO.save(student);
		List<Student> students=studentDAO.findAll();
		model.addAttribute("students", students);
		return "redirect:/students";
	}
	
	@GetMapping(path = "/students/delete/{id}")
	@PreAuthorize(value="hasAuthority('delete:student')")
	public String deleteStudent(@PathVariable(name="id")Integer id,Model model) {
		boolean studentExists=studentDAO.findById(id).isPresent();
		if (studentExists) {
			studentDAO.deleteById(id);
		}else {
			
		}
		List<Student> students=studentDAO.findAll();
		model.addAttribute("students", students);
		
		
		return "redirect:/students";
	}
	
	@GetMapping(path = "/students/edit/{id}")
	@PreAuthorize(value="hasAuthority('edit:student')")
	public String editStudent(@PathVariable(name = "id") Integer id, Model model ){
		Optional<Student> studentOptional= studentDAO.findById(id);
		boolean studentExists = studentOptional.isPresent();
		Student student = new Student();
		if (studentExists) {
			student=studentOptional.get();
		}else {
			
		}
		
		model.addAttribute("student", student);
		model.addAttribute("header", "Tələbə Redaktsəi");
		
		
		return "new-student";
	}
	
}
