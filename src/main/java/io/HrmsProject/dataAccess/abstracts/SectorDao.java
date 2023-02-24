package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.HrmsProject.entities.concretes.Sector;

@Repository
public interface SectorDao extends JpaRepository<Sector, Integer>{
	
	Sector findById(int id);
	

}
