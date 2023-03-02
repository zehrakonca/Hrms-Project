package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.EducationType;

public interface EducationTypeDao extends JpaRepository<EducationType, Integer>{

	EducationType findById(int educationTypeId);
}
