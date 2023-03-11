package io.HrmsProject.business.responses.coverLetterResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdJobSeekerCoverLetterResponse {
	
	private String coverLetter;
	private String coverLetterTitleName;
}
