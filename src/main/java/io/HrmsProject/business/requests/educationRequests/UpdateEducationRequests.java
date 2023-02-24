package io.HrmsProject.business.requests.educationRequests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEducationRequests {
	
	private int educationType;
	private int university;
	private int faculty;
	private int program;
	private LocalDate startedDay;
	private LocalDate graduationDate;
	private int jobSeeker;

}
