package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.business.requests.userRequests.CreateUserRequests;
import io.HrmsProject.business.requests.userRequests.UpdateUserRequests;
import io.HrmsProject.business.responses.userResponses.GetAllUserResponses;
import io.HrmsProject.core.entities.User;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;

public interface UserService  {
	
	Result add(CreateUserRequests createUserRequests)throws Exception;
	Result delete(int id);
	Result update(UpdateUserRequests updateUserRequests)throws Exception;
	
	public List<GetAllUserResponses> getAll();
	public User getById(int id);
	
	DataResult<User> findByEmailAndPassword(String email,String password);
	DataResult<User> findByEmail(String email);
	
}
