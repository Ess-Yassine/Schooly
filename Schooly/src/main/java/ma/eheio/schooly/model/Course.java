package ma.eheio.schooly.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.joda.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Course")
public class Course {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Column(name = "day")
	private Integer day;

	/**
	 * The duration is in minutes.
	 * The startTime is a time without a time-zone, such as 09:00:00.
	 */
	@NotNull
	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "start_time")
	private LocalTime startTime;
	
	@NotNull
	@Column(name = "duration")
	private Integer duration;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "professor_id")
	private Professor professor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "classroom_id")
	private Classroom classroom;

	public Course() {
		super();
	}

	public Course(Long id, @NotNull String name, @NotNull Integer day, @NotNull LocalTime startTime,
			@NotNull Integer duration, Professor professor, Classroom classroom) {
		super();
		this.id = id;
		this.name = name;
		this.day = day;
		this.startTime = startTime;
		this.duration = duration;
		this.professor = professor;
		this.classroom = classroom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
}
