package ma.eheio.schooly.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Notification")
public class Notification {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "description")
	private String description;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "time")
	private LocalDateTime time;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "administrator_id")
	private Administrator administrator;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "professor_id")
	private Professor professor;
	
	public Notification() {
		super();
	}

	public Notification(Long id, String description, LocalDateTime time, Administrator administrator, Professor professor) {
		super();
		this.id = id;
		this.description = description;
		this.time = time;
		this.administrator = administrator;
		this.professor = professor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
