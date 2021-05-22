package ma.eheio.schooly.repository;

import java.util.List;

import ma.eheio.schooly.model.School;

public interface SchoolRepository {

	public void add(School school);
	public void update(School school);
	public void delete(School school);
	public List<School> getAll();
	public School getById(Long id);
	
}
