package io.HrmsProject.business.responses.highSchoolResponses;

import java.util.Date;

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
	private Date startedDate;
	private Date graduationDate;
	private String jobSeeker;
	
	

}
