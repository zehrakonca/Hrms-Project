package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.HrmsProject.entities.concretes.ProgramInfo;

@Repository
public interface ProgramInfoDao extends JpaRepository<ProgramInfo, Integer>{
	
	ProgramInfo findById(int id);

}
