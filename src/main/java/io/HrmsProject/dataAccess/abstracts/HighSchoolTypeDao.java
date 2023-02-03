package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.HighSchoolType;

public interface HighSchoolTypeDao extends JpaRepository<HighSchoolType, Integer>{

	HighSchoolType findById(int id);
}
