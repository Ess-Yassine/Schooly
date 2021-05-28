package ma.eheio.schooly.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
@Entity
@Table(name = "Device")
public class Device {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "label")
	private String label;
	
	@NotNull
	@Column(name = "type")
	private String type;
	
	@NotNull
	@Column(name = "status")
	private Boolean status;
	
	@NotNull
	@Column(name = "number")
	private Long number;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "classroom_id")
	private Classroom classroom;

	public Device() {
		super();
	}

	public Device(Long id, @NotNull String label, @NotNull String type, @NotNull Boolean status,
			@NotNull Long number, Classroom classroom) {
		super();
		this.id = id;
		this.label = label;
		this.type = type;
		this.status = status;
		this.number = number;
		this.classroom = classroom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
}
