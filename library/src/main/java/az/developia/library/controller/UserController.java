package az.developia.library.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.library.dao.LibraryUserDAO;
import az.developia.library.model.LibraryUser;

@Controller
public class UserController {
	
	@Autowired
	private LibraryUserDAO libraryUserDAO;

	private boolean userCreated=false;
	
	@GetMapping(path="/show-login")
	public String showLoginPage(Model model) {
		if(userCreated) {
			model.addAttribute("userCreated", "");
			userCreated=false;
		}
		return "my-custom-login";
	}
	
	@GetMapping(path="/create-account")
	public String showCreateAccountPage(Model model) {
		LibraryUser libraryUser = new LibraryUser();
		model.addAttribute("libraryUser", libraryUser);
		return "create-account";
	}
	
	@PostMapping(path="/create-account-process")
	public String saveUser(@Valid @ModelAttribute(name = "libraryUser") LibraryUser libraryUser,
			BindingResult result, Model model) {
		if(result.hasErrors()){
			return "create-account";
		}
		
		boolean userExists=libraryUserDAO.createUser(libraryUser);
		if (userExists) {
			model.addAttribute("userExists", "");
			return "create-account";
		}
		userCreated=true;
		return "redirect:/show-login";
	}
	
	
}
