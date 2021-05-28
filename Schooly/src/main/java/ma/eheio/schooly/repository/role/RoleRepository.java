package ma.eheio.schooly.repository.role;

import ma.eheio.schooly.enumeration.RoleName;
import ma.eheio.schooly.model.Role;

public interface RoleRepository {

	Role findByName(RoleName rolename);

}
