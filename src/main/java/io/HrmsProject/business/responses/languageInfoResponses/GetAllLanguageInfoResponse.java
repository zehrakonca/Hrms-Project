package io.HrmsProject.business.responses.languageInfoResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguageInfoResponse {
	
	private int languageInfoId;
	private String language;
	private int jobSeekerId;

}
