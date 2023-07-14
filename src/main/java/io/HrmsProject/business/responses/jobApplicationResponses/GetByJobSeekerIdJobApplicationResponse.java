package io.HrmsProject.business.responses.jobApplicationResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByJobSeekerIdJobApplicationResponse {
	
	private int id;
	private int advertisementId;
	private String companyName;
	private String job;
	private String jobDescription;
	private LocalDate applicationDate;

}
