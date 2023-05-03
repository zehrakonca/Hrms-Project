package io.HrmsProject.business.requests.positionLevelRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePositionLevelRequest {

	private int positionLevelId;
	private String positionLevelName;
}
