package io.HrmsProject.business.responses.userResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUserResponses {
	
	private String firstName;
	private String lastName;
	private String telephone;
	private String email;
	private boolean isActive;
	private String userType;
}
