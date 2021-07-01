package ma.eheio.schooly.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import ma.eheio.schooly.model.User;
import ma.eheio.schooly.security.config.CustomUserDetails;
import ma.eheio.schooly.services.user.UserService;

@Controller
public class AccountController {

	@Autowired
	private UserService userService;
	
	@ModelAttribute("loggeduser")
    public User viewDetails(@AuthenticationPrincipal CustomUserDetails loggedUser) {
		String email = loggedUser.getUsername();
		User user = userService.findByEmail(email);
		System.out.println(user.getFirstName());
		return user;
    }
}
