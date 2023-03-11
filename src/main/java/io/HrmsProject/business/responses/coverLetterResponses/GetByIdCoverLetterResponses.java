package io.HrmsProject.business.responses.coverLetterResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCoverLetterResponses {
	
	private String coverLetterTitleName;
	private String coverLetter;
	private int jobSeekerId;
}
