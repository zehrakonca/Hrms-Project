package io.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.HrmsProject.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{
	
	Language findById(int id);

}
