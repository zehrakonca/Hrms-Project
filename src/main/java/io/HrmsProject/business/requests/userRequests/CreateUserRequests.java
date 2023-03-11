package io.HrmsProject.business.requests.userRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequests {
	
	private String firstName;
	private String lastName;
	private String telephone;
	private String email;
	private String password;
	private String passwordRep;
	private boolean isActive;
	private int userStatu;
}
