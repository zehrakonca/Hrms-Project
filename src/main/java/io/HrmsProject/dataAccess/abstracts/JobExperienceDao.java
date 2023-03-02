package io.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.HrmsProject.entities.concretes.JobExperience;

@Repository
public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>{
	
	JobExperience findById(int id);
	List<JobExperience> getByJobSeeker_Id(int jobSeekerId, Sort sort);
	List<JobExperience> getByJobSeeker_Id(int jobSeeker);
}
