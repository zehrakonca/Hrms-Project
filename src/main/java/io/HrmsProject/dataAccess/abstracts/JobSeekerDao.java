package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.HrmsProject.entities.concretes.JobSeeker;

@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{
	
	JobSeeker findById(int id);
	
	JobSeeker findByNationalIdentity(String nationalIdentity);
}
