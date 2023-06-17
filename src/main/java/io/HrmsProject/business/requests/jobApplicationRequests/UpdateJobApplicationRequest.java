package io.HrmsProject.business.requests.jobApplicationRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateJobApplicationRequest {
	
	private int id;
	private int jobSeekerId;
	private int jobAdvertisementId;

}
