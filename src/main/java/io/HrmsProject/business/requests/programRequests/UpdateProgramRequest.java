package io.HrmsProject.business.requests.programRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProgramRequest {
	
	private int programId;
	private String program;

}
