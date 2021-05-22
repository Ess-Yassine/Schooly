package ma.eheio.schooly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import ma.eheio.schooly.model.Professor;

@Component
public interface ProfessorRepositoryJpa extends JpaRepository<Professor, Long> {

	
}
