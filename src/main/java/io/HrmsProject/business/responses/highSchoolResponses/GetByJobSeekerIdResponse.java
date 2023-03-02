package io.HrmsProject.business.responses.highSchoolResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByJobSeekerIdResponse {
	
	private String jobSeeker;
	private String highSchoolName;
	private String highSchoolType;
	private String program;
	private int startedDate;
	private int graduationDate;
}
