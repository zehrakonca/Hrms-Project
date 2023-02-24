package io.HrmsProject.business.responses.highSchoolResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllHighSchoolResponses {
	
	private String highSchoolName;
	private String highSchoolType;
	private String program;
	private int startedDate;
	private int graduationDate;
	private String jobSeeker;
	
	

}
