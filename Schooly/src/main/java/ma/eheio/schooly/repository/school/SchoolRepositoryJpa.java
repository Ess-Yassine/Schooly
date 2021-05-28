package ma.eheio.schooly.repository.school;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import ma.eheio.schooly.model.School;

@Component
public interface SchoolRepositoryJpa extends JpaRepository<School, Long> {

}
