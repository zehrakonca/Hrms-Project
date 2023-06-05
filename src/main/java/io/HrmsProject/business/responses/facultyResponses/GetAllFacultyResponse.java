package io.HrmsProject.business.responses.facultyResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllFacultyResponse {
	
	private int id;
	private String facultyName;

}
