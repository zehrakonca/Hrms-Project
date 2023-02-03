package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.ProgramInfo;

public interface ProgramInfoDao extends JpaRepository<ProgramInfo, Integer>{
	
	ProgramInfo findById(int id);

}
