package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.SystemEmployee;

public interface SystemEmployeeDao extends JpaRepository<SystemEmployee, Integer>{
	
	SystemEmployee findById(int id);

}
