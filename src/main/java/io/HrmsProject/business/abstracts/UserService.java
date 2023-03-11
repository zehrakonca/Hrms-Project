package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.business.requests.userRequests.CreateUserRequests;
import io.HrmsProject.business.requests.userRequests.UpdateUserRequests;
import io.HrmsProject.business.responses.userResponses.GetAllUserResponses;
import io.HrmsProject.core.entities.User;
import io.HrmsProject.core.utilities.results.Result;

public interface UserService  {
	
	Result add(CreateUserRequests createUserRequests)throws Exception;
	Result delete(int id);
	Result update(UpdateUserRequests updateUserRequests, int id)throws Exception;
	
	public List<GetAllUserResponses> getAll();
	public User getById(int id);
	
}
