package io.HrmsProject.business.responses.educationResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByJobSeekerEducationResponses {
	
	private int educationId;
	private int jobSeekerId;
	private String educationTypeName;
	private String universityName;
	private String programName;
	private String facultyName;
	private LocalDate startedDate;
	private LocalDate graduationDate;
}
