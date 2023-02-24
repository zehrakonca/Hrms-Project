package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.HrmsProject.entities.concretes.HighSchool;

@Repository
public interface HighSchoolDao extends JpaRepository<HighSchool, Integer>{
	
	HighSchool findById(int id);
	HighSchool findByJobSeeker_Id(int jobSeekerId);

}
