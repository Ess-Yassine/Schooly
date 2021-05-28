package ma.eheio.schooly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ma.eheio.schooly.model.Notification;
import ma.eheio.schooly.services.notification.NotificationService;

//TO DO : Change @Controller to @RestController
//@RestController
@Controller
@RequestMapping("/notification")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@GetMapping("/new")
	public String add(Model model) {
		
		/**
		 * Create model attribute to bind from data
		 */
		Notification notification = new Notification();
		model.addAttribute("notification", notification);
		return "notification/new_notification";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("notification") Notification notification) {
		/**
		 * Save Notification to database
		 */
		notificationService.add(notification);
		return "redirect:/notification/list";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model)

	{
		/**
		 * Get notification from the service
		 */
		Notification notification = notificationService.findById(id);

		/**
		 * Set notification as a model attribute to pre-populate the form
		 */
		model.addAttribute("notification", notification);

		return "notification/update_notification";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		Notification notification = notificationService.findById(id);
		notificationService.delete(notification);

		return "redirect:/notification/list";
	}

	/**
	 * Display the list of notifications
	 */
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", notificationService.findAll());
		return "notification/list_notifications";
	}
}
