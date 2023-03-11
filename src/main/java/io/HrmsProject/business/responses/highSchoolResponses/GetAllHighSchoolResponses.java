package io.HrmsProject.business.responses.highSchoolResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllHighSchoolResponses {
	
	private int highSchoolId;
	private String highSchoolName;
	private String highSchoolTypeName;
	private String programName;
	private int startedDate;
	private int graduationDate;
	private int jobSeekerId;
}
