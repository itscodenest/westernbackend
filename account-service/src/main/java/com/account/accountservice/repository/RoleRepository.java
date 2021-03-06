package com.account.accountservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.tourcoreservice.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findById(long id);

	@Query(value="SELECT r FROM Role r WHERE r.name=:internalDmcRole")
	List<Role> findInternalb2bRoles(@Param("internalDmcRole") String internalDmcRole);

}
