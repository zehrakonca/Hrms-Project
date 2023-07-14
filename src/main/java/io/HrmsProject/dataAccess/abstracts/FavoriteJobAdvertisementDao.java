package io.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.FavoriteJobAdvertisement;

public interface FavoriteJobAdvertisementDao extends JpaRepository<FavoriteJobAdvertisement, Integer>{
	
	FavoriteJobAdvertisement findById(int id);
	
	List<FavoriteJobAdvertisement> getByJobSeeker_Id(int jobSeekerId);
	
	

}
