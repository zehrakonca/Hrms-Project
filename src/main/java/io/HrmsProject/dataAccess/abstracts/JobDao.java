package io.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.HrmsProject.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer>{
	Job findById(int id);
	
	@Query("From Job where job_Name=:jobName and sector_Id=:sectorId")
	List<Job> getByNameAndSector(String jobName, int sectorId);
	
	@Query("From Job where sector_Id=:sectorId")
	List<Job> getBySector(int sectorId);
}
