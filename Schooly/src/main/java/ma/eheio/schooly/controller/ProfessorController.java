package ma.eheio.schooly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ma.eheio.schooly.model.Professor;
import ma.eheio.schooly.services.ProfessorService;

//TO DO : Change @Controller to @RestController
//@RestController
@Controller
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	//@Autowired
	//private CourseService courseService;

	// TO DO : manage password exception
	@GetMapping("/new")
	public String add(Model model) {
		/**
		 * Create model attribute to bind from data
		 */
		Professor professor = new Professor();
		model.addAttribute("professor", professor);
		return "professor/new_professor";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("professor") Professor professor) {
		/**
		 * Save Professor to database
		 */
		professorService.add(professor);
		return "redirect:/professor/list";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model)

	{
		/**
		 * Get professor from the service
		 */
		Professor professor = professorService.getById(id);

		/**
		 * Set professor as a model attribute to pre-populate the form
		 */
		model.addAttribute("professor", professor);
		//model.addAttribute("course", courseService.getAll());

		return "professor/update_professor";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		Professor professor = professorService.getById(id);
		professorService.delete(professor);

		return "redirect:/professor/list";
	}

	/**
	 * Display the list of professors
	 */
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("listProfessors", professorService.getAll());
		//model.addAttribute("listCourses", courseService.getAll());
		return "professor/list_professors";
	}
}
