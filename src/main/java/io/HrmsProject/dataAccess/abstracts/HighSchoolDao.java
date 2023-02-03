package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.HighSchool;

public interface HighSchoolDao extends JpaRepository<HighSchool, Integer>{
	
	HighSchool findById(int id);

}
