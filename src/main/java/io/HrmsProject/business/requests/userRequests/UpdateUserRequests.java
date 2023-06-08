package io.HrmsProject.business.requests.userRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequests {
	
	private int id;
	private String firstName;
	private String lastName;
	private String telephone;
	private String email;
	private String password;
	private String passwordRep;
}
