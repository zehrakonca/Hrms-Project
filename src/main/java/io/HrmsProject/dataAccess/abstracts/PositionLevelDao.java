package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.PositionLevel;

public interface PositionLevelDao extends JpaRepository<PositionLevel, Integer> {
	
	PositionLevel findById(int id);

}
