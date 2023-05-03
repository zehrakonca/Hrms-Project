package io.HrmsProject.business.responses.experienceResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllExperienceResponse {
	
	private int experienceTypeId;
	private String experienceName;

}
