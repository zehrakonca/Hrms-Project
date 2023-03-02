package io.HrmsProject.business.requests.languageInfoRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLanguageInfoRequest {
	
	private int language;
	private int jobSeeker;

}
