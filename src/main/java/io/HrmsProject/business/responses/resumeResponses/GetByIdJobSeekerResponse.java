package io.HrmsProject.business.responses.resumeResponses;

import java.util.List;

import io.HrmsProject.entities.concretes.Ability;
import io.HrmsProject.entities.concretes.CoverLetter;
import io.HrmsProject.entities.concretes.Education;
import io.HrmsProject.entities.concretes.HighSchool;
import io.HrmsProject.entities.concretes.JobExperience;
import io.HrmsProject.entities.concretes.LanguageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class GetByIdJobSeekerResponse {
	
	int jobSeekerId;
	String firstName;
	String lastName;
	int date;
	String email;
	String telephone;
	String nationalIdentity;
	HighSchool highSchool;
	List<Ability> ability;
	List<Education> education;
	List<LanguageInfo> languageInfo;
	List<JobExperience> jobExperience;
	CoverLetter coverLetter;

}
