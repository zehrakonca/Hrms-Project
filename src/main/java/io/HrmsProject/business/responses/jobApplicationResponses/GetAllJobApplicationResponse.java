package io.HrmsProject.business.responses.jobApplicationResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobApplicationResponse {
	
	private int id;
	private int jobSeekerId;
	private int advertisementId;
	private String firstName;
	private String lastName;
	private String companyName;
	private String job;
	private String jobDescription;
	private LocalDate applicationDate;

}
