package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.SystemEmployeeService;
import io.HrmsProject.business.requests.systemEmployeeRequests.CreateSystemEmployeeRequest;
import io.HrmsProject.business.requests.systemEmployeeRequests.UpdateSystemEmployeeRequest;
import io.HrmsProject.business.responses.systemEmployeeResponses.GetAllSystemEmployeeResponse;
import io.HrmsProject.business.responses.systemEmployeeResponses.GetByIdSystemEmployeeResponse;
import io.HrmsProject.core.dataAccess.UserDao;
import io.HrmsProject.core.dataAccess.UserStatuDao;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.ErrorResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.SystemEmployeeDao;
import io.HrmsProject.entities.concretes.SystemEmployee;
import io.HrmsProject.entities.concretes.UserStatu;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SystemEmployeeManager implements SystemEmployeeService {
	
	private SystemEmployeeDao systemEmployeeDao;
	private UserStatuDao userStatuDao;
	private UserDao userdao;
	private ModelMapperService modelMapperService;

	@Override
	public Result add(CreateSystemEmployeeRequest createEntity) throws Exception {
		SystemEmployee systemEmployee = this.modelMapperService.forRequest().map(createEntity, SystemEmployee.class);
		
		if(!(dataControl(createEntity))) {
			return new ErrorResult("your information is missing. please check your information.");
		}
		else if (!(createEntity.getPassword().equals(createEntity.getPasswordRep()))) {
			return new ErrorResult("these password your entered do not match. please check passwords.");
		}
		else {
			systemEmployee.setActive(createEntity.isActive()==false);
			UserStatu userStatu = this.userStatuDao.findByTypeId(3);
			systemEmployee.setUserStatu(userStatu);
			systemEmployee.setEmail(createEntity.getEmail());
			systemEmployee.setPassword(BCrypt.hashpw(createEntity.getPassword(), BCrypt.gensalt()));
			this.systemEmployeeDao.save(systemEmployee);
			return new SuccessResult("system employee has been created. please wait confirmation mail.");
		}
	}

	@Override
	public Result update(UpdateSystemEmployeeRequest updateEntity) throws Exception {
		SystemEmployee systemEmployee = this.modelMapperService.forRequest().map(updateEntity, SystemEmployee.class);
		systemEmployee.setTelephone(updateEntity.getTelephone());
		systemEmployee.setEmail(updateEntity.getEmail());
		systemEmployee.setPassword(updateEntity.getPassword());
		this.systemEmployeeDao.save(systemEmployee);
	return new SuccessResult("your information has been updated");
	
	}

	@Override
	public Result delete(int id) {
		this.systemEmployeeDao.deleteById(id);
		return new SuccessResult("system employee has been deleted.");
	}

	@Override
	public DataResult<List<GetAllSystemEmployeeResponse>> getAll() {
		List<SystemEmployee> systemEmployees = this.systemEmployeeDao.findAll();
		List<GetAllSystemEmployeeResponse> systemEmployeeResponses = systemEmployees.stream().map(systemEmployee->this.modelMapperService.forResponse().map(systemEmployee, GetAllSystemEmployeeResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllSystemEmployeeResponse>>(systemEmployeeResponses);
	}

	@Override
	public DataResult<GetByIdSystemEmployeeResponse> getById(int id) {
		SystemEmployee systemEmployee = this.systemEmployeeDao.findById(id);
		GetByIdSystemEmployeeResponse response = this.modelMapperService.forResponse().map(systemEmployee, GetByIdSystemEmployeeResponse.class);
		return new SuccessDataResult<GetByIdSystemEmployeeResponse>(response);
	}

	@Override
	public Result makeActiveOrPassive(boolean isActive, int id) {
		SystemEmployee systemEmployee = this.systemEmployeeDao.findById(id);
		String statuMessage = isActive ? "system employee has been activated." 
				   : "system employee has been passived. ";
		
		systemEmployee.setActive(isActive);
		update(systemEmployee, id);
		return new SuccessResult(statuMessage);
	}

	@Override
	public Result update(SystemEmployee systemEmployee, int id) {
		SystemEmployee systemEmployeeUpd = this.systemEmployeeDao.findById(id);
		this.systemEmployeeDao.save(systemEmployeeUpd);
		return new SuccessResult();
		}
	
	private boolean dataControl(CreateSystemEmployeeRequest createSystemEmployeeRequests) {
		if(createSystemEmployeeRequests.getEmail() == null || createSystemEmployeeRequests.getEmail().isBlank()||
		   createSystemEmployeeRequests.getFirstName() == null || createSystemEmployeeRequests.getFirstName().isBlank()||
		   createSystemEmployeeRequests.getLastName()== null || createSystemEmployeeRequests.getLastName().isBlank()||
		   createSystemEmployeeRequests.getTelephone()==null || createSystemEmployeeRequests.getTelephone().isBlank()|| 
		   createSystemEmployeeRequests.getPassword()==null || createSystemEmployeeRequests.getPassword().isBlank())
		{
			return false;
		}
		else {
			return true; 
		}
	}

}
