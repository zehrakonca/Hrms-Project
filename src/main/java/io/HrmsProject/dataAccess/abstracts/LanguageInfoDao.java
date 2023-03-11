package io.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.LanguageInfo;

public interface LanguageInfoDao extends JpaRepository<LanguageInfo, Integer> {

	LanguageInfo findById(int id);
	
	List<LanguageInfo> getByJobSeeker_Id(int jobSeekerId);
}
