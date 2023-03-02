package io.HrmsProject.business.requests.abilityRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAbilityRequests {
	
	private int id;
	private String ability;
	private int jobSeeker;

}
