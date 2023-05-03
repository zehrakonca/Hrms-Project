package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.MilitaryStatu;

public interface MilitaryStatuDao extends JpaRepository<MilitaryStatu, Integer>{

	MilitaryStatu findById(int id);
}
