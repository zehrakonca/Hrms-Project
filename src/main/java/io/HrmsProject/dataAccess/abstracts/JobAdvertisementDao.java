package io.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.HrmsProject.entities.concretes.JobAdvertisement;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	JobAdvertisement findById(int id);
	List<JobAdvertisement> findByAdvertisementNameContainsIgnoreCase(String advertisementName,Sort sort);

	List<JobAdvertisement> getByIsActive(boolean isActive);
	List<JobAdvertisement> getByIsActive(boolean isActive, Sort sort);
	List<JobAdvertisement> getByIsActiveAndEmployer_Id(boolean isActive, int employerId, Sort sort);
	
	List<JobAdvertisement> findByEmployer_CompanyNameAndIsActive(String companyName,Sort sort, boolean isActive);
	//List<JobAdvertisement> findByCity_CityIdAndTypeOfWork_TypeOfWorkId(int cityId, int workTypeId);
}
