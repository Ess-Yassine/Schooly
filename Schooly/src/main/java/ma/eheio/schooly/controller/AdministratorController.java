package ma.eheio.schooly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ma.eheio.schooly.model.Administrator;
import ma.eheio.schooly.services.AdministratorService;

//TO DO : Change @Controller to @RestController
//@RestController
@Controller
@RequestMapping("/administrator")
public class AdministratorController {

	@Autowired
	private AdministratorService administratorService;

	//@Autowired
	//private CourseService courseService;

	// TO DO : manage password exception
	@GetMapping("/new")
	public String add(Model model) {
		
		/**
		 * Create model attribute to bind from data
		 */
		Administrator administrator = new Administrator();
		model.addAttribute("administrator", administrator);
		return "administrator/new_administrator";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("administrator") Administrator administrator) {
		
		/**
		 * Save Administrator to database
		 */
		administratorService.add(administrator);
		return "redirect:/administrator/list";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model)

	{
		/**
		 * Get administrator from the service
		 */
		Administrator administrator = administratorService.getById(id);

		/**
		 * Set administrator as a model attribute to pre-populate the form
		 */
		model.addAttribute("administrator", administrator);

		return "administrator/update_administrator";
	}

	@GetMapping("/delete/{id}")
	public String Delete(@PathVariable Long id) {
		Administrator administrator = administratorService.getById(id);
		administratorService.delete(administrator);

		return "redirect:/administrator/list";
	}

	/**
	 * Display the list of administrators
	 */
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("listAdministrators", administratorService.getAll());
		//model.addAttribute("listCourses", courseService.getAll());
		return "administrator/list_administrators";
	}
}
