package az.developia.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(path={"/home","/"})
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping(path={"/library"})
	public String showLibraryPage() {
		return "library";
	}
	
}
