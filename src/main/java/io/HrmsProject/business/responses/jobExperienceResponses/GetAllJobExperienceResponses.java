package io.HrmsProject.business.responses.jobExperienceResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllJobExperienceResponses {
	
	private String companyName;
	private String position;
	private String jobDescription;
	private String city;
	private LocalDate startedDate;
	private LocalDate endDate;
	private String sector;
	private int jobSeeker;
}