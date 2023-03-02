package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

	City findById(int id);
}
