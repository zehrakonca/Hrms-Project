package io.HrmsProject.business.responses.jobAdvertisementResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobAdvertisementResponses {
	
	private String advertisementName;
	private String sector;
	private String job;
	private String city;
	private String employer;
	private int numberOfVacancies;
	private String jobDescription;
	private int jobSalaryMin;
	private int jobSalaryMax;
	private LocalDate releaseDate;
	private LocalDate applicationDate;

}
