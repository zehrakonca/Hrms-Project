package io.HrmsProject.business.responses.socialMediaResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSocialMediaResponse {
	
	private int socialMediaId;
	private String linkedinAccount;
	private String githubAccount;
	private String twitterAccount;
	private int jobSeekerId;

}
