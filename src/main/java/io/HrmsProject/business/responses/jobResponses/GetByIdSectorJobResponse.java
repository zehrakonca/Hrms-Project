package io.HrmsProject.business.responses.jobResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdSectorJobResponse {
	
	private String jobName;
	private String sector;

}
