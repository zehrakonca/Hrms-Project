package io.HrmsProject.business.requests.educationRequests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEducationRequests {
	
	private int educationType;
	private int university;
	private int faculty;
	private int program;
	private LocalDate startedDate;
	private LocalDate graduationDate;
	private int jobSeeker;

}
