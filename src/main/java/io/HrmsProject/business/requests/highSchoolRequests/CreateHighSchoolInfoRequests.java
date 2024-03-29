package io.HrmsProject.business.requests.highSchoolRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHighSchoolInfoRequests {
	
	private String highSchoolName;
	private int highSchoolType;
	private int program;
	private int startedDate;
	private int graduationDate;
	private int jobSeekerId;
	

}
