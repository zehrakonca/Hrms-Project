package io.HrmsProject.business.responses.jobAdvertisementResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobAdvertisementByEmployer {
	
	private String advertisementName;
	private String jobDescription;
	private int numberOfVacancies;
	private LocalDate releaseDate;
	private LocalDate applicationDate;


}
