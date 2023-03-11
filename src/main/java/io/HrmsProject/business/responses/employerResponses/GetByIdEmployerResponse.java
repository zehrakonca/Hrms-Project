package io.HrmsProject.business.responses.employerResponses;

import io.HrmsProject.business.responses.userResponses.GetAllUserResponses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GetByIdEmployerResponse extends GetAllUserResponses{
	
	private String companyName;
	private String webSiteName;
	private String companyMail;
	private String companyDescription;
}
