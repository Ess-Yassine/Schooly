package ma.eheio.schooly.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Administrator")
public class Administrator extends User {
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "administrator")
	private List<Notification> notifications;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Classroom> classrooms;
	
	public Administrator() {
		
	}

	public Administrator(List<Notification> notifications, List<Classroom> classrooms) {
		super();
		this.notifications = notifications;
		this.classrooms = classrooms;
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
