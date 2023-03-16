package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer> {
	
	Image findByUser_Id(int userId);

}
