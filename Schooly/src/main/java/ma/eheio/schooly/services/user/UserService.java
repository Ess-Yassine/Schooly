package ma.eheio.schooly.services.user;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import ma.eheio.schooly.dto.UserRegistrationDto;
import ma.eheio.schooly.model.User;

public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDto userRegistrationDto);
	void update(User user);
	void delete(User user);
	
	User findById(Long id);
	List<User> findAll();
	
}
