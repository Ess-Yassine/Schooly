package ma.eheio.schooly.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import ma.eheio.schooly.model.User;

@Component
public interface UserRepositoryJpa extends JpaRepository<User, Long> {

	User findByEmail(String email);
	User findByUsername(String username);
	User findByResetPasswordToken(String resetPasswordToken);
	
	/*
	@Query("SELECT user FROM User user WHERE user.username=:username AND user.password=:password")
	User findByCredentials(@Param("username") String username, @Param("password") String password);
	*/
	

}
