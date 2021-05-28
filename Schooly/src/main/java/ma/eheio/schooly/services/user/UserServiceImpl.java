package ma.eheio.schooly.services.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.eheio.schooly.model.User;
import ma.eheio.schooly.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void add(User user) {
		userRepository.add(user);
	}

	@Override
	public void update(User user) {
		userRepository.update(user);
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

	@Override
	public User findById(Long id) {

		return userRepository.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
}
