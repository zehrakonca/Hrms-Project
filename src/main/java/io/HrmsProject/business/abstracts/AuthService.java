package io.HrmsProject.business.abstracts;

import io.HrmsProject.core.entities.User;
import io.HrmsProject.core.entities.UserLogin;
import io.HrmsProject.core.utilities.results.DataResult;

public interface AuthService {
	
	DataResult<User> login (UserLogin userLogin);

}
