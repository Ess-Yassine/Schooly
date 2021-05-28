package ma.eheio.schooly.services.user;

import java.util.List;

import ma.eheio.schooly.model.User;

public interface UserService {
	
	void add(User user);
	void update(User user);
	void delete(User user);
	User findById(Long id);
	List<User> findAll();
	
}
