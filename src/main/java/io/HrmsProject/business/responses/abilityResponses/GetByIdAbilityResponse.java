package io.HrmsProject.business.responses.abilityResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdAbilityResponse {
	
	private String abilityName;
	private int jobSeekerId;

}
