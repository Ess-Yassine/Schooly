package ma.eheio.schooly.repository.user;

import java.util.List;

import ma.eheio.schooly.model.User;

public interface UserRepository {

	User save(User user);
	void update(User user);
	void delete(User user);
	
	List<User> findAll();
	User findById(Long id);
	User findByEmail(String email);
	User findByUsername(String username);
	
	/*

	User findByCredentials(String username, String password);	
	
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);*/
	
}
