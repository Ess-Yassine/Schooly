package ma.eheio.schooly.repository.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.eheio.schooly.enumeration.RoleName;
import ma.eheio.schooly.model.Role;

public interface RoleRepositoryJpa extends JpaRepository<Role, Long> {

	@Query("SELECT role FROM Role role WHERE role.name=:name")
	Role findByName(@Param("name") RoleName rolename);
}
