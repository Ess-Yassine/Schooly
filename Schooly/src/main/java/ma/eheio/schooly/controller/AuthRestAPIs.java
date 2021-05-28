package ma.eheio.schooly.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.eheio.schooly.dto.request.Register;
import ma.eheio.schooly.dto.response.ResponseMessage;
import ma.eheio.schooly.enumeration.RoleName;
import ma.eheio.schooly.exception.ResourceNotFoundException;
import ma.eheio.schooly.model.Role;
import ma.eheio.schooly.model.User;
import ma.eheio.schooly.repository.role.RoleRepository;
import ma.eheio.schooly.repository.user.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public ResponseEntity<ResponseMessage> registerUser(@Valid @RequestBody Register registerRequest)
			throws ResourceNotFoundException {

		/**
		 * Prevent a user from registering with a username or an e-mail that are already
		 * in use.
		 */
		if (userRepository.existsByUsername(registerRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Username is already taken!"), HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByemail(registerRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Email is already in use!"), HttpStatus.BAD_REQUEST);
		}

		/**
		 * Create user's account
		 */
		User user = new User(registerRequest.getFirstName(), registerRequest.getLastName(), registerRequest.getPhone(),
				registerRequest.getEmail(), registerRequest.getUsername(),
				passwordEncoder.encode(registerRequest.getPassword()));

		Set<String> rolesRequest = registerRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		rolesRequest.forEach(role -> {

			switch (role) {

				case "admin":
					Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN);
					if (adminRole == null) {
						throw new ResourceNotFoundException("Role Not Found!");
					}
					roles.add(adminRole);
					break;
	
				default:
					Role userRole = roleRepository.findByName(RoleName.ROLE_USER);
					if (userRole == null) {
						throw new ResourceNotFoundException("Role Not Found!");
					}
					roles.add(userRole);
				}
		});

		user.setRoles(roles);
		userRepository.add(user);
		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
}
