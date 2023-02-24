package io.HrmsProject.business.requests.jobExperienceRequests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobExperienceRequests {
	
	private String companyName;
	private String position;
	private String jobDescription;
	private int city;
	private LocalDate startedDate;
	private LocalDate endDate;
	private int sector;
	private int jobSeeker;

}
