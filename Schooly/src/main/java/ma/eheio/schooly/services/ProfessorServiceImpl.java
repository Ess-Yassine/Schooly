package ma.eheio.schooly.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import ma.eheio.schooly.model.Professor;
import ma.eheio.schooly.repository.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	ProfessorRepository professorRepository;

	@Override
	public void add(@RequestBody Professor professor) {
		professorRepository.add(professor);
	}

	@Override
	public void update(Professor professor) {
		professorRepository.update(professor);
	}

	@Override
	public void delete(Professor professor) {
		professorRepository.delete(professor);
	}

	@Override
	public Professor getById(Long id) {
		return professorRepository.getById(id);
	}

	@Override
	public List<Professor> getAll() {
		return professorRepository.getAll();
	}
}
