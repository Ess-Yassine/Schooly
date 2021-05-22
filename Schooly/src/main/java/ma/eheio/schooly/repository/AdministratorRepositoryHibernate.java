package ma.eheio.schooly.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.eheio.schooly.model.Administrator;

@Repository
public class AdministratorRepositoryHibernate implements AdministratorRepository {

	@Autowired
	AdministratorRepositoryJpa administratorRepositoryJpa;

	@Override
	public void add(Administrator administrator) {
		administratorRepositoryJpa.save(administrator);
	}

	@Override
	public void update(Administrator administrator) {
		administratorRepositoryJpa.save(administrator);
	}

	@Override
	public void delete(Administrator administrator) {
		administratorRepositoryJpa.delete(administrator);
	}

	@Override
	public Administrator getById(Long id) {

		Administrator administrator = null;
		
		Optional<Administrator> administratorOptional = administratorRepositoryJpa.findById(id);
		administrator = administratorOptional.get();
		if (!administratorOptional.isPresent()) {
			throw new RuntimeException("Administrator not Found for id :" + id);
		}
		return administrator;
	}

	@Override
	public List<Administrator> getAll() {
		return administratorRepositoryJpa.findAll();
	}

}
