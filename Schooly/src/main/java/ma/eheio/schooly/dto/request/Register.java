package ma.eheio.schooly.dto.request;

import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Register {

	@NotNull
	@Column(name = "user_id")
	private String userID;

	@NotNull
	@Column(name = "first_name")
	@Size(min = 3, max = 30)
	private String firstName;

	@NotNull
	@Column(name = "last_name")
	@Size(min = 3, max = 30)
	private String lastName;

	@NotNull
	@Column(name = "phone")
	private String phone;

	@NotNull
	@Email
	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "username", unique = true)
	@Size(min = 3, max = 50)
	private String username;

	@Column(name = "password")
	@Size(min = 8, max = 20)
	private String password;

	private Set<String> roles;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
}
