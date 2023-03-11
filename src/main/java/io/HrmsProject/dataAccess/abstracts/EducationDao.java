package io.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.HrmsProject.entities.concretes.Education;

@Repository
public interface EducationDao extends JpaRepository<Education, Integer> {
	
	Education findById(int educationId);
	
	List<Education> getByJobSeeker_Id(int jobSeekerId, Sort sort);

}
