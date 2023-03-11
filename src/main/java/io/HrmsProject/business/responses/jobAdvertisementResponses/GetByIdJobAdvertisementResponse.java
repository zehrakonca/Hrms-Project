package io.HrmsProject.business.responses.jobAdvertisementResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdJobAdvertisementResponse {
	
	private int advertisementId;
	private String advertisementName;
	private String sectorName;
	private String jobName;
	private String cityName;
	private String companyName;
	private int numberOfVacancies;
	private String jobDescription;
	private int jobSalaryMin;
	private int jobSalaryMax;
	private LocalDate releaseDate;
	private LocalDate applicationDate;
	private boolean isActive;

}
