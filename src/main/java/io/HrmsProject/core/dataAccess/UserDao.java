package io.HrmsProject.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.HrmsProject.core.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	
	User findById(int id);

}
