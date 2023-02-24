package io.HrmsProject.business.responses.educationResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdEducationResponse {
	
	private int jobSeeker;
	private String educationType;
	private String university;
	private String program;
	private String faculty;
	private LocalDate startedDate;
	private LocalDate graduationDate;

}
