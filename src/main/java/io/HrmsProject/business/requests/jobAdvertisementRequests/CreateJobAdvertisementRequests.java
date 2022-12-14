package io.HrmsProject.business.requests.jobAdvertisementRequests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobAdvertisementRequests {
	
	private String advertisementName;
	private int sector;
	private int job;
	private int city;
	private int employer;
	private int numberOfVacancies;
	private String jobDescription;
	private int jobSalaryMin;
	private int jobSalaryMax;
	private LocalDate releaseDate;
	private LocalDate applicationDate;
	private boolean isActive;
	
}
