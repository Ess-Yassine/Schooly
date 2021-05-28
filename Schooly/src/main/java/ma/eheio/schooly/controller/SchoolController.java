package ma.eheio.schooly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ma.eheio.schooly.model.School;
import ma.eheio.schooly.services.school.SchoolService;

//TO DO : Change @Controller to @RestController
//@RestController
@Controller
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	private SchoolService schoolService;
	//@Autowired
	//private ClassroomService classroomService;
	
	@GetMapping("/new")
	public String add(Model model) {
		
		/**
		 * Create model attribute to bind from data
		 */
		School school = new School();
		model.addAttribute("school", school);
		return "school/new_school";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("school") School school) {
		
		/**
		 * Save school to database
		 */
		schoolService.add(school);
		return "redirect:/school/list";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model)

	{
		/**
		 * Get school from the service
		 */
		School school = schoolService.findById(id);

		/**
		 * Set school as a model attribute to pre-populate the form
		 */
		model.addAttribute("school", school);
		//model.addAttribute("classroom", classroomService.getAll());
		return "school/update_school";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		School school = schoolService.findById(id);
		schoolService.delete(school);
		return "redirect:/school/list";
	}
	
	/**
	 * Display the list of schools
	 */
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", schoolService.findAll());
		//model.addAttribute("listClassrooms", classroomService.getAll());
		return "school/list_schools";
	}
}
