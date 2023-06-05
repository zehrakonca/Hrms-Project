package io.HrmsProject.business.responses.jobAdvertisementResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobAdvertisementResponses {
	
	private int advertisementId;
	private String advertisementName;
	private String sectorName;
	private String jobName;
	private String cityName;
	private String companyName;
	private int numberOfVacancies;
	private String jobDescription;
	private int jobSalary;
	private LocalDate releaseDate;
	private LocalDate applicationDate;
	//private String workTypeName;
	private String experienceName;
	private String militaryStatuName;
	private String positionLevelName;
	private String educationTypeName;
	private boolean isActive;

}
