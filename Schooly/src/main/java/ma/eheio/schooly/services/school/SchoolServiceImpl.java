package ma.eheio.schooly.services.school;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.eheio.schooly.model.School;
import ma.eheio.schooly.repository.school.SchoolRepository;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	SchoolRepository schoolRepository;
	
	@Override
	public void add(School school) {
		schoolRepository.add(school);
	}

	@Override
	public void update(School school) {
		schoolRepository.update(school);
	}

	@Override
	public void delete(School school) {
		schoolRepository.delete(school);
	}

	@Override
	public School findById(Long id) {
		return schoolRepository.findById(id);
	}

	@Override
	public List<School> findAll() {
		return schoolRepository.findAll();
	}

}
