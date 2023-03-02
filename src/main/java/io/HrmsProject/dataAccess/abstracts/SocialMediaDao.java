package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.SocialMedia;

public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer>{
	
	SocialMedia findById(int id);
	SocialMedia findByJobSeeker_Id(int jobSeekerId);
}
