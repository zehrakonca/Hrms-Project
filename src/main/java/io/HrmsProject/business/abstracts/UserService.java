package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.business.requests.userRequests.CreateUserRequests;
import io.HrmsProject.business.requests.userRequests.UpdateUserRequests;
import io.HrmsProject.business.responses.userResponses.GetAllUserResponses;
import io.HrmsProject.core.entities.User;

public interface UserService  {
	
	void add(CreateUserRequests createUserRequests)throws Exception;
	void delete(int id);
	void update(UpdateUserRequests updateUserRequests, int id)throws Exception;
	
	public List<GetAllUserResponses> getAll();
	public User getById(int id);
	
}
