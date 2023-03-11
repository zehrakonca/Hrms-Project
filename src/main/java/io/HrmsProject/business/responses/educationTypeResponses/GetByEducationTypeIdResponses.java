package io.HrmsProject.business.responses.educationTypeResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByEducationTypeIdResponses {
	
	private int educationTypeId;
	private String educationTypeName;

}
