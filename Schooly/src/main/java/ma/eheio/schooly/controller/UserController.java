package ma.eheio.schooly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ma.eheio.schooly.model.User;
import ma.eheio.schooly.services.user.UserService;

//TO DO : Change @Controller to @RestController
//@RestController
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	//@Autowired
	//private CourseService courseService;

	// TO DO : manage password exception
	@GetMapping("/new")
	public String add(Model model) {
		
		/**
		 * Create model attribute to bind from data
		 */
		User user = new User();
		model.addAttribute("user", user);
		return "user/new_user";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("user") User user) {
		
		/**
		 * Save User to database
		 */
		userService.add(user);
		return "redirect:/user/list";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model)

	{
		/**
		 * Get user from the service
		 */
		User user = userService.findById(id);

		/**
		 * Set user as a model attribute to pre-populate the form
		 */
		model.addAttribute("user", user);

		return "user/update_user";
	}

	@GetMapping("/delete/{id}")
	public String Delete(@PathVariable Long id) {
		User user = userService.findById(id);
		userService.delete(user);

		return "redirect:/user/list";
	}

	/**
	 * Display the list of users
	 */
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("listUsers", userService.findAll());
		//model.addAttribute("listCourses", courseService.getAll());
		return "user/list_users";
	}
}
