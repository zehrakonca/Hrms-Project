package io.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.HrmsProject.entities.concretes.Employer;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer>{
	
	Employer findById(int id);

	List<Employer> getByIsActive(boolean isActive);
	
	Employer findByCompanyName(String companyName);
}
