package ma.eheio.schooly.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.eheio.schooly.model.Professor;

@Repository
public class ProfessorRepositoryHibernate implements ProfessorRepository {

	@Autowired
	ProfessorRepositoryJpa professorRepositoryJpa;
	
	@Override
	public void add(Professor professor) {
		professorRepositoryJpa.save(professor);
	}

	@Override
	public void update(Professor professor) {
		professorRepositoryJpa.save(professor);
	}

	@Override
	public void delete(Professor professor) {
		professorRepositoryJpa.delete(professor);
	}

	@Override
	public Professor getById(Long id) {

		Professor professor = null;

		Optional<Professor> ProfessorOptional = professorRepositoryJpa.findById(id);
		
		professor = ProfessorOptional.get();
		
		if (!ProfessorOptional.isPresent()) {
			
			throw new RuntimeException("Professor not Font" + id);
		}
		return professor;
	}

	@Override
	public List<Professor> getAll() {
		return professorRepositoryJpa.findAll();
	}
}
