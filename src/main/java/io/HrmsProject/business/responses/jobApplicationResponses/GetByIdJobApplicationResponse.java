package io.HrmsProject.business.responses.jobApplicationResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdJobApplicationResponse {
	
	private int id;
	private int advertisementId;
	private String firstName;
	private String lastName;
	private String companyName;
	private String job;
	private LocalDate applicationDate;

}
