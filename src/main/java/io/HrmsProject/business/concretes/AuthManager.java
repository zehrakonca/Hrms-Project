package io.HrmsProject.business.concretes;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.AuthService;
import io.HrmsProject.business.abstracts.UserService;
import io.HrmsProject.core.entities.User;
import io.HrmsProject.core.entities.UserLogin;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.ErrorResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessResult;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {

	private UserService userService;
	private ModelMapperService modelMapperService;

	@Override
	public Result login(UserLogin userLogin) {
		
		User user = this.modelMapperService.forRequest().map(userLogin, User.class);
		DataResult<User> userFindEmail = this.userService.findByEmail(userLogin.getEmail());

		if (userFindEmail.isSuccess()) {
			String storedHashedPassword = userFindEmail.getData().getPassword();
			boolean isMatch = BCrypt.checkpw(userLogin.getPassword(), storedHashedPassword);

			if (isMatch) {
				userLogin.setEmail(userFindEmail.getData().getEmail());
				userLogin.setPassword(userFindEmail.getData().getPassword());
				
				this.userService.findByEmail(userLogin.getEmail());
				
				return new SuccessResult("Welcome back.");
			}	
			return new ErrorResult("Email or password is incorrect.");
		}
		return new SuccessResult("i dont know what to do.");
	}
}
