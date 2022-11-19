package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.business.requests.userRequests.CreateUserStatuRequest;
import io.HrmsProject.business.responses.userResponses.GetAllUserStatuResponse;
import io.HrmsProject.entities.concretes.UserStatu;

public interface UserStatuService {
	
	void add(CreateUserStatuRequest createUserStatuRequest) throws Exception;
	
	public List<GetAllUserStatuResponse> getAll();
	
	public UserStatu getById(int id);

}
