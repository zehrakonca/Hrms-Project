package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.LanguageInfo;

public interface LanguageInfoDao extends JpaRepository<LanguageInfo, Integer> {

	LanguageInfo findById(int id);
	
	LanguageInfo findByJobSeeker_Id(int jobSeekerId);
}
