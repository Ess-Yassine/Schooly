package ma.eheio.schooly.model;

import org.joda.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.MappedSuperclass;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@MappedSuperclass
public abstract class User {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "full_name")
	@Size(min = 3, max = 50)
	private String fullName;

	@NotNull
	@Column(name = "phone")
	private String phone;
	
	@NotNull
	@Column(name = "email")
	private String email;

	@Column(name = "username")
	@Size(min = 3, max = 50)
	private String username;

	@Column(name = "password")
	@Size(min = 8, max = 20)
	private String password;
	
	@Column(name = "last_connection")
	private LocalDateTime lastConnection;

	public User() {
		super();
	}

	public User(Long id, @NotNull @Size(min = 3, max = 50) String fullName, @NotNull String phone,
			@NotNull String email, @Size(min = 3, max = 50) String username, @Size(min = 8, max = 20) String password,
			LocalDateTime lastConnection, List<Notification> notifications, List<Classroom> classrooms) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
		this.lastConnection = lastConnection;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public LocalDateTime getLastConnection() {
		return lastConnection;
	}

	public void setLastConnection(LocalDateTime lastConnection) {
		this.lastConnection = lastConnection;
	}
}
