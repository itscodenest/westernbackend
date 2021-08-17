package com.core.coreserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.User;

@Repository
public interface EmployeeRepository extends JpaRepository<User, Long> {
	User findById(long id);
}
