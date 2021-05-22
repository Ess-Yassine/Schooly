package ma.eheio.schooly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import ma.eheio.schooly.model.Administrator;

@Component
public interface AdministratorRepositoryJpa extends JpaRepository<Administrator, Long> {

}
