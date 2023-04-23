package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.TypeOfWork;

public interface TypeOfWorkDao  extends JpaRepository<TypeOfWork, Integer>{
	
	TypeOfWork findById(int id);

}
