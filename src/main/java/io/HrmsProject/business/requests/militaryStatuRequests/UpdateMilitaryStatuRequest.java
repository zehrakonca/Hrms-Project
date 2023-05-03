package io.HrmsProject.business.requests.militaryStatuRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMilitaryStatuRequest {

	public int militaryStatuId;
	public String militaryStatuName;
}
