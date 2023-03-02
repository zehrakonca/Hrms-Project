package io.HrmsProject.business.responses.languageInfoResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdJobSeekerLanguageInfoResponse {
	
	private int jobSeeker;
	private String language;
}
