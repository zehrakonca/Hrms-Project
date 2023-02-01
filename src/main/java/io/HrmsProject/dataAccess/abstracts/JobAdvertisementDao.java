package io.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	JobAdvertisement findById(int id);
	//JobAdvertisement getByAdvertisementName(String advertisementName);

	List<JobAdvertisement> getByIsActive(boolean isActive);
	List<JobAdvertisement> getByIsActive(boolean isActive, Sort sort);
	List<JobAdvertisement> getByIsActiveAndEmployer_Id(boolean isActive, int employerId, Sort sort);
	
	List<JobAdvertisement> getByEmployer_CompanyNameAndIsActiveTrue(String companyName);
}