package ma.eheio.schooly.repository;

import java.util.List;

import ma.eheio.schooly.model.Professor;

public interface ProfessorRepository {

	public void add(Professor professor);
	public void update(Professor professor);
	public void delete(Professor professor);
	public List<Professor> getAll();
	public Professor getById(Long id);
	
}
