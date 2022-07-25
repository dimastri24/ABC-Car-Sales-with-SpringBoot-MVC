package com.lithan.csp.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lithan.csp.entity.Roles;

@Repository
public interface RoleRepo extends JpaRepository<Roles, Long>{

	@Query( "select r from Roles r where r.name in :roles" )
	Set<Roles> findBySpecificRoles(@Param("roles") String role);
}
