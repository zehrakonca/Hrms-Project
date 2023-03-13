package io.HrmsProject.business.responses.universityResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUniversityResponse {
	
	private int id;
	private String universityName;

}
