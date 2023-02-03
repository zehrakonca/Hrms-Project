package io.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.University;

public interface UniversityDao extends JpaRepository<University, Integer>{

	University findById(int id);
	List<University> getByUniversityName(String universityName);
}
