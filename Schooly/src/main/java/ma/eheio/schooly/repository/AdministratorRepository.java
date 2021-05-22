package ma.eheio.schooly.repository;

import java.util.List;

import org.springframework.context.annotation.Bean;

import ma.eheio.schooly.model.Administrator;

public interface AdministratorRepository {

	public void add(Administrator administrator);
	public void update(Administrator administrator);
	public void delete(Administrator administrator);
	public List<Administrator> getAll();
	@Bean
	public Administrator getById(Long id);
	
}
