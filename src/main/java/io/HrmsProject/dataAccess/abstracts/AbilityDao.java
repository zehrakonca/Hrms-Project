package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.HrmsProject.entities.concretes.Ability;

@Repository
public interface AbilityDao extends JpaRepository<Ability, Integer>{

	Ability findById(int id);
}
