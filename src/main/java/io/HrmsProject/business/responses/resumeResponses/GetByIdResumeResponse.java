package io.HrmsProject.business.responses.resumeResponses;

import java.time.LocalDateTime;
import java.util.List;

import io.HrmsProject.entities.concretes.Ability;
import io.HrmsProject.entities.concretes.CoverLetter;
import io.HrmsProject.entities.concretes.Education;
import io.HrmsProject.entities.concretes.HighSchool;
import io.HrmsProject.entities.concretes.Image;
import io.HrmsProject.entities.concretes.JobExperience;
import io.HrmsProject.entities.concretes.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdResumeResponse {
	
	private LocalDateTime createdDate;
	
	private String firstName;
	
	private String lastName;
	
	private String telephone;
	
	private String email;
	
	private CoverLetter coverLetter;
	
	private Image image;
	
	private List<JobExperience> jobExperiences;
	
	private List<Education> educations;
	
	private HighSchool highSchool;
	
	private List<Ability> abilities;
	
	private List<Language> languages;
	

}
