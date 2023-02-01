package io.HrmsProject.business.requests.jobAdvertisementRequests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateJobAdvertisementRequests {
	
	private int advertisementId;
	private String jobDescription;
	private int numberOfVacancies;
	private int jobSalaryMin;
	private int jobSalaryMax;
	private LocalDate applicationDate;
	private boolean isActive;
}
