package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.HrmsProject.entities.concretes.Employer;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer>{
	
	Employer findById(int id);

}
