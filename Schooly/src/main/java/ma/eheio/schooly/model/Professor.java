package ma.eheio.schooly.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Professor")
public class Professor extends User {

	@Column(name = "code")
	private String code;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professor")
	private List<Course> courses;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professor")
	private List<Notification> notifications;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Classroom> classrooms;

	public Professor() {
		super();
	}

	public Professor(String code, List<Course> courses, List<Notification> notifications, List<Classroom> classrooms) {
		super();
		this.code = code;
		this.courses = courses;
		this.notifications = notifications;
		this.classrooms = classrooms;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
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
}
