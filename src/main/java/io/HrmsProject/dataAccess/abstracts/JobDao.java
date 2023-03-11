package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.HrmsProject.entities.concretes.Job;

@Repository
public interface JobDao extends JpaRepository<Job, Integer>{
	
	Job findById(int id);
	
	//@Query("From Job where job_Name=:jobName and sector_Id=sectorId")
	Job findByJobName(String jobName);
	
	//@Query("From Job where sector_id=sectorId")
	Job getBySector(@Param("sector_id") int sectorId);
}
