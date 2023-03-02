package io.HrmsProject.business.responses.programResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgramResponse {
	
	private int programId;
	private String program;

}
