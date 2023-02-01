package io.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.Faculty;

public interface FacultyDao extends JpaRepository<Faculty, Integer>{
	
	Faculty findById(int id);
	
	List<Faculty> getByFacultyName(String facultyName);

}
