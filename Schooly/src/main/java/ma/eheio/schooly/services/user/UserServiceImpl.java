package ma.eheio.schooly.services.user;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ma.eheio.schooly.dto.UserRegistrationDto;
import ma.eheio.schooly.enumeration.RoleName;
import ma.eheio.schooly.exception.ResourceNotFoundException;
import ma.eheio.schooly.model.Role;
import ma.eheio.schooly.model.User;
import ma.eheio.schooly.repository.role.RoleRepository;
import ma.eheio.schooly.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	private UserRepository userRepository;
	
	private RoleRepository roleRepository;

	

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public User save(UserRegistrationDto userRegistrationDto) {
		User user = new User(userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(),
				userRegistrationDto.getPhone(), userRegistrationDto.getEmail(), userRegistrationDto.getUsername(),
				passwordEncoder.encode(userRegistrationDto.getPassword()), Arrays.asList(AddRole(RoleName.USER)));
		return userRepository.save(user);
	}

	private Role AddRole(RoleName rolename) {
		if (roleRepository.findByName(rolename) == null) {
			return new Role(rolename);
		} return roleRepository.findByName(rolename);
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id);
	}
	
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
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
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid email or password!");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName().toString()))
				.collect(Collectors.toList());
	}

	@Override
	public User findByResetPasswordToken(String resetPasswordToken) {
		return userRepository.findByResetPasswordToken(resetPasswordToken);
	}

	@Override
	public void updateResetPasswordToken(String token, String email) {
		
		User user = findByEmail(email);
		if(user != null) {
			user.setResetPasswordToken(token);
			userRepository.save(user);
		} else {
			throw new ResourceNotFoundException("Could not find any user with email : " + email);
		}
	}

	@Override
	public void updatePassword(User user, String password) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);
		user.setPassword(encodedPassword);
		user.setResetPasswordToken(null);
		userRepository.save(user);
	}
}
