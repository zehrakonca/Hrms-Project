package io.HrmsProject.business.responses.employerResponses;

import io.HrmsProject.business.responses.userResponses.GetAllUserResponses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GetAllEmployerResponses extends GetAllUserResponses{
	
	private int id;
	private String companyName;
	private String webSiteName;
	private String companyMail;
	private String companyDescription;
}
