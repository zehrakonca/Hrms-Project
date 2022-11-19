package io.HrmsProject.business.requests.employerRequests;

import io.HrmsProject.business.requests.userRequests.CreateUserRequests;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployerRequests extends CreateUserRequests{
	
	private String companyName;
	private String webSiteName;
	private String companyMail;
	private String companyDescription;
	private String userType = "1";

}
