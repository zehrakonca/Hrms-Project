package io.HrmsProject.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User findById(int id);

}
