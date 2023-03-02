package io.HrmsProject.business.requests.abilityRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAbilityRequests {
	
	private String ability;
	private int jobSeeker;

}
