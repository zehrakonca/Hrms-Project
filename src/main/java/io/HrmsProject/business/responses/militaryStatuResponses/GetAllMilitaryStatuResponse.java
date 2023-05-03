package io.HrmsProject.business.responses.militaryStatuResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllMilitaryStatuResponse {
	
	private int militaryStatuId;
	private String militaryStatuName;

}
