package ma.eheio.schooly.services.school;

import java.util.List;

import ma.eheio.schooly.model.School;

public interface SchoolService {

	public void add(School school);
	public void update(School school);
	public void delete(School school);
	public School findById(Long id);
	public List<School> findAll();
}
