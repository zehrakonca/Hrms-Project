package io.HrmsProject.business.requests.employerRequests;

import io.HrmsProject.business.requests.userRequests.UpdateUserRequests;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UpdateEmployerRequests extends UpdateUserRequests {
	
	private String companyName;
	private String webSiteName;
	private String companyMail;
	private String companyDescription;

}
