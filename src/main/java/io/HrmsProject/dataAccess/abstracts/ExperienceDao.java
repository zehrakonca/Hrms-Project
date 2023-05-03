package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.Experience;

public interface ExperienceDao extends JpaRepository<Experience, Integer>{
	
	Experience findById(int id);
}
