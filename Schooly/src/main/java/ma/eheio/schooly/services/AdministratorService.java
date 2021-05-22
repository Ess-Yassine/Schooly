package ma.eheio.schooly.services;

import java.util.List;

import ma.eheio.schooly.model.Administrator;

public interface AdministratorService {
	
	void add(Administrator administrator);
	void update(Administrator administrator);
	void delete(Administrator administrator);
	public Administrator getById(Long id);
	public List<Administrator> getAll();
	
}
