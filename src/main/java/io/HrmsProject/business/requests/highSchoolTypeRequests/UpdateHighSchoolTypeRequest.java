package io.HrmsProject.business.requests.highSchoolTypeRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateHighSchoolTypeRequest {
	
	private int highSchoolTypeId;
	private String highSchoolType;

}
