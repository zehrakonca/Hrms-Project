package io.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.HrmsProject.entities.concretes.Job;

@Repository
public interface JobDao extends JpaRepository<Job, Integer>{
	
	Job findById(int id);

	List<Job> findByJobNameContainsIgnoreCase(String jobName);
	
	List<Job> findBySector_SectorId(int sectorId);
}
