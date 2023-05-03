package io.HrmsProject.business.responses.positionLevelResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPositionLevelResponse {
	
	private int positionLevelId;
	private String positionLevelName;

}
