package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.Sector;

public interface SectorDao extends JpaRepository<Sector, Integer>{
	
	Sector findById(int id);
	

}
