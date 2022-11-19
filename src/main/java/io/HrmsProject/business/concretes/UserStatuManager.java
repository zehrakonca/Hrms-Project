package io.HrmsProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.UserStatuService;
import io.HrmsProject.business.requests.userRequests.CreateUserStatuRequest;
import io.HrmsProject.business.responses.userResponses.GetAllUserStatuResponse;
import io.HrmsProject.core.dataAccess.UserStatuDao;
import io.HrmsProject.entities.concretes.UserStatu;

@Service
public class UserStatuManager implements UserStatuService {
	
	private UserStatuDao userStatuDao;

	@Autowired
	public UserStatuManager(UserStatuDao userStatuDao) {
		super();
		this.userStatuDao = userStatuDao;
	}

	@Override
	public UserStatu getById(int id) {
		return this.userStatuDao.findByTypeId(id);
	}

	@Override
	public void add(CreateUserStatuRequest createUserStatuRequest) throws Exception {
		UserStatu userStatu = new UserStatu();
		
		userStatu.setTypeName(createUserStatuRequest.getTypeName());
		
		this.userStatuDao.save(userStatu);
		throw new Exception("user type added");
	}

	@Override
	public List<GetAllUserStatuResponse> getAll() {
		List<UserStatu> userStatus = userStatuDao.findAll();
		List<GetAllUserStatuResponse> allUserStatuResponses = new ArrayList<GetAllUserStatuResponse>();
		
		for (UserStatu userStatu : userStatus) {
			GetAllUserStatuResponse responseItem = new GetAllUserStatuResponse();
			responseItem.setId(userStatu.getTypeId());
			responseItem.setTypeName(userStatu.getTypeName());
			allUserStatuResponses.add(responseItem);
		}
		return allUserStatuResponses;
	}
	
}
