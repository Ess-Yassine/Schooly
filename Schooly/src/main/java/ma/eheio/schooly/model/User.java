package ma.eheio.schooly.model;

import org.joda.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Table(name = "User", uniqueConstraints = { @UniqueConstraint(columnNames = { "phone", "email", "username" }) })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "first_name", length = 50)
	private String firstName;

	@NotNull
	@Column(name = "last_name", length = 50)
	private String lastName;

	@NotNull
	@Column(name = "phone", length = 50)
	private String phone;

	@NotNull
	// @NaturalId
	@Email
	@Column(name = "email", unique = true, length = 50)
	private String email;

	@Column(name = "username", unique = true, length = 50)
	private String username;

	@Column(name = "password", length = 50)
	private String password;
	
	@Column(name = "reset_password_token")
    private String resetPasswordToken;

	@Column(name = "last_connection")
	private LocalDateTime lastConnection;

	@Column(name = "last_connection_display")
	private LocalDateTime lastConnectionDisplay;

	/*
	 * =============================== To be added later on
	 * ===============================
	 * 
	 */

	/*
	 * @NotNull
	 * 
	 * @Column(name = "user_id", length = 50) private String userID;
	 */

	/*
	 * @NotNull
	 * 
	 * @Column(name = "gender") private String gender;
	 */

	/*
	 * @Column(name = "profile_image_url") private String profileImageUrl;
	 */

	/*
	 * @Column(name = "join_date") private String joinDate;
	 */

	/*
	 * @Column(name = "status") private boolean isActive;
	 */

	/*
	 * @Column(name = "lock") private boolean isNotLocked;
	 */

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Classroom> classrooms;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Course> courses;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_notifications", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "notification_id", referencedColumnName = "id") })
	private List<Notification> notifications;

	public User(@NotNull @Size(min = 3, max = 30) String firstName, @NotNull @Size(min = 3, max = 30) String lastName,
			@NotNull String phone, @NotNull String email, @Size(min = 3, max = 50) String username,
			@Size(min = 8, max = 20) String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public User(@NotNull @Size(min = 3, max = 30) String firstName, @NotNull @Size(min = 3, max = 30) String lastName,
			@NotNull String phone, @NotNull @Email String email, @Size(min = 3, max = 50) String username,
			@Size(min = 8, max = 20) String password, Collection<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public User(@NotNull String firstName, @NotNull String lastName, @NotNull String phone,
			@NotNull @Email String email, String username, String password, String resetPasswordToken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
		this.resetPasswordToken = resetPasswordToken;
	}

	public User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public LocalDateTime getLastConnection() {
		return lastConnection;
	}

	public void setLastConnection(LocalDateTime lastConnection) {
		this.lastConnection = lastConnection;
	}

	public LocalDateTime getLastConnectionDisplay() {
		return lastConnectionDisplay;
	}

	public void setLastConnectionDisplay(LocalDateTime lastConnectionDisplay) {
		this.lastConnectionDisplay = lastConnectionDisplay;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public List<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(List<Classroom> classrooms) {
		this.classrooms = classrooms;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
}
