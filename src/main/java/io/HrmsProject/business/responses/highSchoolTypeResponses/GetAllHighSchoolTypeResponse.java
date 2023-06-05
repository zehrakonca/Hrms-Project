package io.HrmsProject.business.responses.highSchoolTypeResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllHighSchoolTypeResponse {
	
	private int id;
	private String highSchoolType;

}
