package io.HrmsProject.business.requests.experienceRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateExperienceRequest {
	
	private int experienceTypeId;
	private String experienceName;

}
