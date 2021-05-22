package ma.eheio.schooly.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.eheio.schooly.model.Administrator;
import ma.eheio.schooly.repository.AdministratorRepository;

@Service
public class AdministratorServiceImpl implements AdministratorService {

	@Autowired
	AdministratorRepository administratorRepository;

	@Override
	public void add(Administrator administrator) {
		administratorRepository.add(administrator);
	}

	@Override
	public void update(Administrator administrator) {
		administratorRepository.update(administrator);
	}

	@Override
	public void delete(Administrator administrator) {
		administratorRepository.delete(administrator);
	}

	@Override
	public Administrator getById(Long id) {

		return administratorRepository.getById(id);
	}

	@Override
	public List<Administrator> getAll() {
		return administratorRepository.getAll();
	}
}
