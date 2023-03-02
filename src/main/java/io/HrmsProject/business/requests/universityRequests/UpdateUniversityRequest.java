package io.HrmsProject.business.requests.universityRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUniversityRequest {
	
	private int universityId;
	private String university;

}
