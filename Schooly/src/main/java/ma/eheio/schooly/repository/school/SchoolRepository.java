package ma.eheio.schooly.repository.school;

import java.util.List;

import ma.eheio.schooly.model.School;

public interface SchoolRepository {

	void add(School school);
	void update(School school);
	void delete(School school);
	List<School> findAll();
	School findById(Long id);
	
}
