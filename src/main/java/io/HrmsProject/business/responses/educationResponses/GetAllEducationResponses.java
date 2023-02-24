package io.HrmsProject.business.responses.educationResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEducationResponses {
	
	private String educationType;
	private String university;
	private String faculty;
	private String program;
	private LocalDate startedDay;
	private LocalDate graduationDate;
	private String jobSeeker;

}
