package io.HrmsProject.business.concretes;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.AuthService;
import io.HrmsProject.business.abstracts.UserService;
import io.HrmsProject.core.entities.User;
import io.HrmsProject.core.entities.UserLogin;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.ErrorDataResult;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {

	private UserService userService;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<User> login(UserLogin userLogin) {
		
		DataResult<User> userFindEmail = this.userService.findByEmail(userLogin.getEmail());

		if (userFindEmail.isSuccess()) {
			User user = userFindEmail.getData();
			String storedHashedPassword = user.getPassword();
			boolean isMatch = BCrypt.checkpw(userLogin.getPassword(), storedHashedPassword);

			if (isMatch) {
				user.setEmail(userFindEmail.getData().getEmail());
				user.setPassword(userFindEmail.getData().getPassword());
				
				return new SuccessDataResult<User>(user,"Welcome back.");
			}	
			return new ErrorDataResult<User>("Email or password is incorrect.");
		}
		return new SuccessDataResult<User>("user not found.");
	}
}
