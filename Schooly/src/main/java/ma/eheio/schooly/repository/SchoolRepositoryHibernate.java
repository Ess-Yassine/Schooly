package ma.eheio.schooly.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.eheio.schooly.model.School;

@Repository
public class SchoolRepositoryHibernate implements SchoolRepository {

	@Autowired
	SchoolRepositoryJpa schoolRepositoryJpa;
	
	@Override
	public void add(School school) {
		schoolRepositoryJpa.save(school);
	}

	@Override
	public void update(School school) {
		schoolRepositoryJpa.save(school);
	}

	@Override
	public void delete(School school) {
		schoolRepositoryJpa.delete(school);
	}

	@Override
	public List<School> getAll() {
		return schoolRepositoryJpa.findAll();
	}

	@Override
	public School getById(Long id) {

		School school = null;

		Optional<School> SchoolOptional = schoolRepositoryJpa.findById(id);
		
		school = SchoolOptional.get();
		
		if (!SchoolOptional.isPresent()) {
			
			throw new RuntimeException("School not Font" + id);
		}
		return school;
	}

}
