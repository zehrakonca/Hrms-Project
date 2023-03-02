package io.HrmsProject.business.responses.abilityResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAbilityResponses {

	private int id;
	private String abilityName;
	private int jobSeeker;
}
