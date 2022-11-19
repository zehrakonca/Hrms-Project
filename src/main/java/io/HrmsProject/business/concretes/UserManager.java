package io.HrmsProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.UserService;
import io.HrmsProject.business.requests.userRequests.CreateUserRequests;
import io.HrmsProject.business.requests.userRequests.UpdateUserRequests;
import io.HrmsProject.business.responses.userResponses.GetAllUserResponses;
import io.HrmsProject.core.dataAccess.UserDao;
import io.HrmsProject.core.dataAccess.UserStatuDao;
import io.HrmsProject.core.entities.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	private UserStatuDao userStatuDao;
	
	@Autowired
	public UserManager(UserDao userDao, UserStatuDao userStatuDao) {
		super();
		this.userDao = userDao;
		this.userStatuDao = userStatuDao;
	}

	@Override
	public void add(CreateUserRequests createUserRequests) throws Exception {
		User user = new User();
		
		user.setFirstName(createUserRequests.getFirstName());
		user.setLastName(createUserRequests.getLastName());
		user.setTelephone(createUserRequests.getTelephone()); 
		user.setEmail(createUserRequests.getMail());
		user.setPassword(createUserRequests.getPassword());
		user.setPasswordRep(createUserRequests.getPasswordRep()); 
		user.setActive(createUserRequests.isActive()== false); 
			
		this.userDao.save(user);
		throw new Exception("user added.");
		
	}

	@Override
	public void delete(int id) {
		this.userDao.deleteById(id);
	}

	@Override
	public void update(UpdateUserRequests updateUserRequests, int id) throws Exception {
		
		User user = userDao.findById(id);
		
		user.setFirstName(updateUserRequests.getFirstName());
		user.setLastName(updateUserRequests.getLastName());
		user.setEmail(updateUserRequests.getMail());
		user.setTelephone(updateUserRequests.getTelephone());
		user.setPassword(updateUserRequests.getPassword());
		user.setPasswordRep(updateUserRequests.getPasswordRep());

		this.userDao.save(user);
		throw new Exception("user information saved.");
		
	}

	@Override
	public List<GetAllUserResponses> getAll() {
		List<User> users = userDao.findAll();
		List<GetAllUserResponses> userResponses = new ArrayList<GetAllUserResponses>();
		
		for(User user : users) {
			GetAllUserResponses responseItem = new GetAllUserResponses();
			responseItem.setFirstName(user.getFirstName());
			responseItem.setLastName(user.getLastName());
			responseItem.setMail(user.getEmail());
			responseItem.setTelephone(user.getTelephone());
			responseItem.setActive(user.isActive());
//			responseItem.setUserType(user.getUserStatu().getTypeName());
			userResponses.add(responseItem);
		}
		return userResponses;
	}

	@Override
	public User getById(int id) {
	return this.userDao.findById(id);
	}

}
