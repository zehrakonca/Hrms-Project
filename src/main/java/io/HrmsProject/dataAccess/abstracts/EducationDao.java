package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {
	
	Education findById(int id);
	
	Education findByJobSeeker_Id(int jobSeekerId);

}
