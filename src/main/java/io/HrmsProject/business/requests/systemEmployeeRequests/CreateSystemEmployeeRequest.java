package io.HrmsProject.business.requests.systemEmployeeRequests;

import io.HrmsProject.business.requests.userRequests.CreateUserRequests;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CreateSystemEmployeeRequest extends CreateUserRequests{
	
	private int userType;
}
