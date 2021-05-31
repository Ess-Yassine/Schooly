package ma.eheio.schooly.repository.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.eheio.schooly.model.User;

@Repository
public class UserRepositoryHibernate implements UserRepository {

	@Autowired
	UserRepositoryJpa userRepositoryJpa;

	@Override
	public void add(User user) {
		userRepositoryJpa.save(user);
	}

	@Override
	public void update(User user) {
		userRepositoryJpa.save(user);
	}

	@Override
	public void delete(User user) {
		userRepositoryJpa.delete(user);
	}

	@Override
	public User findById(Long id) {

		User user = null;
		
		Optional<User> userOptional = userRepositoryJpa.findById(id);
		user = userOptional.get();
		if (!userOptional.isPresent()) {
			throw new RuntimeException("User not Found for id :" + id);
		}
		return user;
	}
	
	@Override
	public User findByEmail(String email) {
		return userRepositoryJpa.findByEmail(email);
	}

	@Override
	public List<User> findAll() {
		return userRepositoryJpa.findAll();
	}

	@Override
	public User findByUsername(String username) {
		return userRepositoryJpa.findByUsername(username);
	}
	
	@Override
	public User findByCredentials(String username, String password) {
		return userRepositoryJpa.findByCredentials(username, password);
	}

	@Override
	public boolean existsByUsername(String username) {
		
		boolean exist = (findByUsername(username) != null) ? true :  false;
		return exist;
	}
	@Override
	public boolean existsByEmail(String email) {

		boolean exist = (findByEmail(email) != null) ? true :  false;
		return exist;
	}

}
