package ma.eheio.schooly.services;

import java.util.List;

import ma.eheio.schooly.model.Professor;

public interface ProfessorService {

	public void add(Professor professor);
	public void update(Professor professor);
	public void delete(Professor professor);
	public Professor getById(Long id);
	public List<Professor> getAll();
}
