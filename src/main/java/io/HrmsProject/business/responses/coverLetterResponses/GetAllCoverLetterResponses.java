package io.HrmsProject.business.responses.coverLetterResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCoverLetterResponses {
	
	private String coverLetter;
	private String coverLetterTitleName;
	private int jobSeekerId;
}
