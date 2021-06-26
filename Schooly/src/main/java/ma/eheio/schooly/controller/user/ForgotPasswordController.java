package ma.eheio.schooly.controller.user;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ma.eheio.schooly.exception.ResourceNotFoundException;
import ma.eheio.schooly.model.User;
import ma.eheio.schooly.services.user.UserService;
import ma.eheio.schooly.utilities.GenerateURL;
import net.bytebuddy.utility.RandomString;

@Controller
public class ForgotPasswordController {

	@Autowired
	private UserService userService;

	@Autowired
	private JavaMailSender mailSender;

	@GetMapping("/forgot_password")
	public String showForgotPasswordForm() {
		return "authentication/reset_password";
	}

	@PostMapping("/forgot_password")
	public String resetPassword(HttpServletRequest request, Model model) {
		String email = request.getParameter("email");
		String token = RandomString.make(45);

		try {
			userService.updateResetPasswordToken(token, email);

			/**
			 * Generate Reset Password Link
			 */
			String resetPasswordLink = GenerateURL.getSiteURL(request) + "/reset_password?token=" + token;

			/**
			 * Send E-mail to user
			 */
			sendEmail(email, resetPasswordLink);
			model.addAttribute("message", "We have sent a reset password link to you email!");

		} catch (ResourceNotFoundException ex) {
			model.addAttribute("error", ex.getMessage());
		} catch (UnsupportedEncodingException | MessagingException e) {
			model.addAttribute("error", "There was an error sending the email");
			
		}
		if(userService.findByEmail(email) != null) {
			return "redirect:/forgot_password?success";
		} else return "redirect:/forgot_password?error";
		
	}

	private void sendEmail(String email, String resetPasswordLink)
			throws UnsupportedEncodingException, MessagingException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom("tt5608755@gmail.com", "Schooly support");
		helper.setTo(email);
		/**
		 * Email content
		 */
		String subject = "Here is the link to reset your password";
		String content = "<p>Hello,</p>" 
				+ "<p>You have requested to reset your password?</p>"
				+ "<p>Click the link below to change it : </p>" 
				+ "<a href=\"" + resetPasswordLink + "\">Change Password</a>"
				+ "<p>Ignore this email if you did NOT made the request.</p>";
		
		helper.setSubject(subject);
		helper.setText(content, true);
		mailSender.send(message);
	}
	
	@GetMapping("/reset_password")
	public String showChangePasswordForm(@Param(value = "token") String token, Model model) {
		User user = userService.findByResetPasswordToken(token);
		if (user == null) {
			model.addAttribute("title", "Reset Password");
			model.addAttribute("message", "Invalid Token");
			return "message";
		}
		model.addAttribute("token", token);
		return "authentication/change_password";
	}
	
	@PostMapping("/reset_password")
	public String updatePassword(HttpServletRequest request, Model model) {
		String token = request.getParameter("token");
		String password = request.getParameter("password");
		User user = userService.findByResetPasswordToken(token);
		if (user == null) {
			model.addAttribute("title", "Reset Password");
			model.addAttribute("message", "Invalid Token");
			return "message";
		} else {
			userService.updatePassword(user, password);
			System.out.println(password);
			model.addAttribute("message", "You have successfully changed your password!");
		}
		return "redirect:/login";
	}
}
