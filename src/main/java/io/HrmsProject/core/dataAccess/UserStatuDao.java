package io.HrmsProject.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.UserStatu;

public interface UserStatuDao extends JpaRepository<UserStatu, Integer>{
	
	UserStatu findByTypeId(int id);
}
