package io.HrmsProject.business.abstracts;

import io.HrmsProject.core.entities.UserLogin;
import io.HrmsProject.core.utilities.results.Result;

public interface AuthService {
	
	Result login (UserLogin userLogin);

}
