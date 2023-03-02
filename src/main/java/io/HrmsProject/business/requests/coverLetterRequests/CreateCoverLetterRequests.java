package io.HrmsProject.business.requests.coverLetterRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCoverLetterRequests {
	
	private String coverLetter;
	private int jobSeeker;

}
