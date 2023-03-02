package io.HrmsProject.business.requests.facultyRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFacultyRequests {
	
	private int facultyId;
	private String faculty;

}
