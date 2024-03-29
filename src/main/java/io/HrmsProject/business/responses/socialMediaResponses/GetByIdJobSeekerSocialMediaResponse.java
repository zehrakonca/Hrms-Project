package io.HrmsProject.business.responses.socialMediaResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdJobSeekerSocialMediaResponse {
	
	private int socialMediaId;
	private int jobSeekerId;
	private String linkedinAccount;
	private String githubAccount;
	private String twitterAccount;
}
