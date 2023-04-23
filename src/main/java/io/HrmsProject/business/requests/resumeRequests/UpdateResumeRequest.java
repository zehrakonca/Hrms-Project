package io.HrmsProject.business.requests.resumeRequests;

import java.util.List;

import io.HrmsProject.business.requests.abilityRequests.CreateAbilityRequests;
import io.HrmsProject.business.requests.coverLetterRequests.CreateCoverLetterRequests;
import io.HrmsProject.business.requests.educationRequests.CreateEducationRequests;
import io.HrmsProject.business.requests.highSchoolRequests.CreateHighSchoolInfoRequests;
import io.HrmsProject.business.requests.imageRequests.CreateImageRequest;
import io.HrmsProject.business.requests.jobExperienceRequests.CreateJobExperienceRequests;
import io.HrmsProject.business.requests.languageInfoRequests.CreateLanguageInfoRequest;
import lombok.Data;

@Data
public class UpdateResumeRequest {
	
	private int jobSeekerId;
	
	private CreateCoverLetterRequests coverLetter;
	
	private List<CreateJobExperienceRequests> experience;
	
	private List<CreateEducationRequests> education;
	
	private CreateHighSchoolInfoRequests highSchool;
	
	private List<CreateAbilityRequests> ability;
	
	private List<CreateLanguageInfoRequest> language;
	
	private CreateImageRequest image;

}
