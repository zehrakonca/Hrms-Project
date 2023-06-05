package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.HrmsProject.entities.concretes.Experience;

@Repository
public interface ExperienceDao extends JpaRepository<Experience, Integer>{
	
	Experience findById(int id);
}
