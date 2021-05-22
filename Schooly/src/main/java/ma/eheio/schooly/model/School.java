package ma.eheio.schooly.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "School")
public class School {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Column(name = "address")
	private String address;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "school")
	private List<Classroom> classrooms;

	public School() {
		super();
	}

	public School(Long id, @NotNull String name, @NotNull String address, List<Classroom> classrooms) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.classrooms = classrooms;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(List<Classroom> classrooms) {
		this.classrooms = classrooms;
	}
}
