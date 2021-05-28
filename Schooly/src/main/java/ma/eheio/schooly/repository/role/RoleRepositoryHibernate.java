package ma.eheio.schooly.repository.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.eheio.schooly.enumeration.RoleName;
import ma.eheio.schooly.model.Role;

@Repository
public class RoleRepositoryHibernate implements RoleRepository{

	@Autowired
	RoleRepositoryJpa roleRepositoryJpa;
	
	@Override
	public Role findByName(RoleName rolename) {
		return roleRepositoryJpa.findByName(rolename);
	}

	
}
