package io.HrmsProject.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.UserService;
import io.HrmsProject.business.requests.userRequests.CreateUserRequests;
import io.HrmsProject.business.requests.userRequests.UpdateUserRequests;
import io.HrmsProject.business.responses.userResponses.GetAllUserResponses;
import io.HrmsProject.core.dataAccess.UserDao;
import io.HrmsProject.core.entities.User;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.ErrorDataResult;
import io.HrmsProject.core.utilities.results.ErrorResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements UserService{

	private UserDao userDao;
	private ModelMapperService modelMapperService;

	@Override
	public Result add(CreateUserRequests createUserRequests) throws Exception {
		User user = this.modelMapperService.forRequest().map(createUserRequests, User.class);
		
		if(!(isMailExist(createUserRequests.getEmail()))){
			return new ErrorResult("your mail already registered. please check your information.");
		}
		else {
			user.setActive(createUserRequests.isActive()== false);
			this.userDao.save(user);
			return new SuccessResult();
		}
	}

	@Override
	public Result delete(int id) {
		this.userDao.deleteById(id);
		return new SuccessResult();
	}

	@Override
	public Result update(UpdateUserRequests updateUserRequests) throws Exception {
		User user = this.userDao.findById(updateUserRequests.getId()).orElseThrow();
		if(!isMailExist(updateUserRequests.getEmail())){
			return new ErrorResult("your mail already registered. please check your information.");
		}
		else {
			this.userDao.save(user);
			return new SuccessResult();
		}
	}

	@Override
	public List<GetAllUserResponses> getAll() {
		List<User> users = userDao.findAll();
		List<GetAllUserResponses> userResponses = new ArrayList<GetAllUserResponses>();
		
		for(User user : users) {
			GetAllUserResponses responseItem = new GetAllUserResponses();
			responseItem.setFirstName(user.getFirstName());
			responseItem.setLastName(user.getLastName());
			responseItem.setEmail(user.getEmail());
			responseItem.setTelephone(user.getTelephone());
			responseItem.setActive(user.isActive());
			responseItem.setUserType(user.getUserStatu().getTypeName());
			userResponses.add(responseItem);
		}
		return userResponses;
	}

	@Override
	public User getById(int id) {
	return this.userDao.findById(id).orElseThrow();
	}
	
	private boolean isMailExist(String mail) {
		List<User> users = userDao.findAll();
		
		for(User user : users) {
			if(user.getEmail().equalsIgnoreCase(mail)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public DataResult<User> findByEmailAndPassword(String email, String password) {
		Optional<User> user = this.userDao.findByEmailAndPassword(email, password);
		if(user.isPresent()) {
			return new SuccessDataResult<User>(user.get());
		}
		else {
			return new ErrorDataResult<User>("email or password is incorrect.");
		}
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		Optional<User> user = this.userDao.findByEmail(email);
		if(user.isPresent()) {
			return new SuccessDataResult<User>(user.get());
		}
		else {
			return new ErrorDataResult<User>("email is incorrect.");
		}
	}

	
	
	

}
