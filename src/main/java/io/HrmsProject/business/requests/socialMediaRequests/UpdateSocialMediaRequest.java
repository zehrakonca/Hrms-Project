package io.HrmsProject.business.requests.socialMediaRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSocialMediaRequest {
	
	private int socialMediaId;
	private String linkedinAccount;
	private String githubAccount;
	private String twitterAccount;
	private int jobSeekerId;

}
