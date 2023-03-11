package io.HrmsProject.business.responses.jobExperienceResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByJobSeekerIdResponse {
	
	private int experienceId;
	private String companyName;
	private String position;
	private String jobDescription;
	private String cityName;
	private LocalDate startedDate;
	private LocalDate endDate;
	private String sectorName;
	private int jobSeekerId;

}
