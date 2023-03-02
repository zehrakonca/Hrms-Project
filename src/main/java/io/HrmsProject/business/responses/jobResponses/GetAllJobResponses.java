package io.HrmsProject.business.responses.jobResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobResponses {
	
	private String sectorName;
	private String job;
}