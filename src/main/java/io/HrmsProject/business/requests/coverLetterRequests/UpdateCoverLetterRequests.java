package io.HrmsProject.business.requests.coverLetterRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCoverLetterRequests {

	private int coverLetterId;
	private String coverLetter;
	private String coverLetterTitleName;
	private int jobSeekerId;
}
