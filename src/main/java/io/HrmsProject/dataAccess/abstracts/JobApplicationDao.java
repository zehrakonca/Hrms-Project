package io.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.HrmsProject.entities.concretes.JobApplication;

@Repository
public interface JobApplicationDao extends JpaRepository<JobApplication, Integer>{
	
	JobApplication findById(int id);
	
	List<JobApplication> findByJobSeeker_Id(int jobSeekerId);
	
	List<JobApplication> findByJobAdvertisement_Employer_Id(int employerId);
	

}
