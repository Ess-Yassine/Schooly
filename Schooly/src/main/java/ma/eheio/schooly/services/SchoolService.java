package ma.eheio.schooly.services;

import java.util.List;

import ma.eheio.schooly.model.School;

public interface SchoolService {

	public void add(School school);
	public void update(School school);
	public void delete(School school);
	public School getById(Long id);
	public List<School> getAll();
}
