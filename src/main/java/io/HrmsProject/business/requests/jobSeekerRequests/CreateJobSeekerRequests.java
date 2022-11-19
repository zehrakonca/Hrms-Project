package io.HrmsProject.business.requests.jobSeekerRequests;

import io.HrmsProject.business.requests.userRequests.CreateUserRequests;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CreateJobSeekerRequests extends CreateUserRequests{

	private String nationalIdentity;
	private int date;
	private String userType = "2";
}
