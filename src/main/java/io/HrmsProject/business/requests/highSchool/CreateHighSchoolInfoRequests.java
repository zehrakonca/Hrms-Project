package io.HrmsProject.business.requests.highSchool;

import java.util.Date;

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
	private Date startedDate;
	private Date graduationDate;
	private int jobSeeker;
	

}
