package ma.eheio.schooly.services.user;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import ma.eheio.schooly.dto.UserRegistrationDto;
import ma.eheio.schooly.model.User;

public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDto userRegistrationDto);
	void updateResetPasswordToken(String token, String email);
	void updatePassword(User user, String password);
	User findByResetPasswordToken(String resetPasswordToken);
	
	void update(User user);
	void delete(User user);
	
	List<User> findAll();
	User findById(Long id);
	User findByEmail(String email);
	
}
