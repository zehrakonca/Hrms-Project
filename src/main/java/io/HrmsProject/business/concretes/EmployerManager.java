package io.HrmsProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.EmployerService;
import io.HrmsProject.business.requests.employerRequests.CreateEmployerRequests;
import io.HrmsProject.business.requests.employerRequests.UpdateEmployerRequests;
import io.HrmsProject.business.responses.employerResponses.GetAllEmployerResponses;
import io.HrmsProject.core.dataAccess.UserStatuDao;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.ErrorResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.core.validations.concretes.MailValidation;
import io.HrmsProject.dataAccess.abstracts.EmployerDao;
import io.HrmsProject.entities.concretes.Employer;
import io.HrmsProject.entities.concretes.UserStatu;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private UserStatuDao userStatuDao;
	boolean isExist = false;

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserStatuDao userStatuDao) {
		super();
		this.employerDao = employerDao;
		this.userStatuDao = userStatuDao;
	}

	@Override
	public Result add(CreateEmployerRequests createEmployerRequests){
		Employer employer = new Employer();
		employer.setFirstName(createEmployerRequests.getFirstName());
		employer.setLastName(createEmployerRequests.getLastName());
		employer.setEmail(createEmployerRequests.getMail());
		employer.setCompanyMail(createEmployerRequests.getCompanyMail());
		employer.setTelephone(createEmployerRequests.getTelephone());
		employer.setCompanyName(createEmployerRequests.getCompanyName());
		employer.setWebSiteName(createEmployerRequests.getWebSiteName());
		employer.setCompanyDescription(createEmployerRequests.getCompanyDescription());
		employer.setPassword(createEmployerRequests.getPassword());
		employer.setPasswordRep(createEmployerRequests.getPasswordRep());
		if(!dataControl(createEmployerRequests)) {
			return new ErrorResult("your information is missing. please check information.");
		}
		else if(!MailValidation.checkEmail(createEmployerRequests.getCompanyMail())) {
			return new ErrorResult("the email you entered doesnt match the format.");
		}
		else if(isEmployerExist(createEmployerRequests.getCompanyName())) {
			return new ErrorResult("this company name already exist in database");
		}
		else if(!MailValidation.checkEmailDomain(createEmployerRequests.getWebSiteName(), createEmployerRequests.getCompanyMail())) {
			return new ErrorResult("the email you entered must countain the name of the website. ");
		}
		else if(isMailExist(createEmployerRequests.getCompanyMail())) {
			return new ErrorResult("the email you entered already exist. ");
		}
		else if(!createEmployerRequests.getPassword().equals(createEmployerRequests.getPasswordRep())) {
			return new ErrorResult("passwords do not match. please check.");
		}
		else {
			employer.setActive(createEmployerRequests.isActive() == false);
			UserStatu userStatu = this.userStatuDao.findByTypeId(createEmployerRequests.getUserType());
			employer.setUserStatu(userStatu);;
			this.employerDao.save(employer);
			return new SuccessResult("employer has been created. please wait confirmation mail.");
		}
	}

	@Override
	public Result update(UpdateEmployerRequests updateEmployerRequests, int id){
		
		Employer employer = employerDao.findById(id);
		
		if(employer.getCompanyName().equalsIgnoreCase(updateEmployerRequests.getCompanyName())) {
			return new ErrorResult("this company name already exist");
		}
		else {
			employer.setFirstName(updateEmployerRequests.getFirstName());
			employer.setLastName(updateEmployerRequests.getLastName());
			employer.setEmail(updateEmployerRequests.getMail());
			employer.setCompanyMail(updateEmployerRequests.getCompanyMail());
			employer.setTelephone(updateEmployerRequests.getTelephone());
			employer.setWebSiteName(updateEmployerRequests.getWebSiteName());
			employer.setCompanyDescription(updateEmployerRequests.getCompanyDescription());
			employer.setPassword(updateEmployerRequests.getPassword());
			employer.setPasswordRep(updateEmployerRequests.getPasswordRep());
			employer.setCompanyName(updateEmployerRequests.getCompanyName());
			this.employerDao.save(employer);
		}
		return new SuccessResult("your information has been updated.");
	}
	@Override
		public DataResult<List<GetAllEmployerResponses>> getAll() {
		List<Employer> employers = employerDao.findAll();
		List<GetAllEmployerResponses> employerResponses = new ArrayList<GetAllEmployerResponses>();
		
		for(Employer employer : employers) {
			GetAllEmployerResponses responseItem = new GetAllEmployerResponses();
			responseItem.setId(employer.getId());
			responseItem.setCompanyName(employer.getCompanyName());
			responseItem.setFirstName(employer.getFirstName());
			responseItem.setLastName(employer.getLastName());
			responseItem.setMail(employer.getEmail());
			responseItem.setTelephone(employer.getTelephone());
			responseItem.setCompanyDescription(employer.getCompanyDescription());
			responseItem.setUserType(employer.getUserStatu().getTypeName());
			responseItem.setWebSiteName(employer.getWebSiteName());
			responseItem.setCompanyMail(employer.getCompanyMail());
			employerResponses.add(responseItem);
			}
		return new SuccessDataResult<List<GetAllEmployerResponses>>(employerResponses);
		}
		
	@Override
	public Result delete(int id) {
		this.employerDao.deleteById(id);
		return new SuccessResult("your information has been deleted.");
	}

	

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.findById(id));
	}
	
	private boolean isEmployerExist(String companyName) {
		List<Employer> employers = employerDao.findAll();
		
		for(Employer employer : employers) {
			if(employer.getCompanyName().equalsIgnoreCase(companyName)) {
				isExist = true;
			}
		}
		return isExist;
	}
	
	private boolean isMailExist(String mail){
		List<Employer> employers = employerDao.findAll();
		
		for(Employer employer : employers) {
			if(employer.getCompanyMail().equalsIgnoreCase(mail)) {
				isExist = true;
			}
		}
		return isExist;
	}
	
	private boolean dataControl(CreateEmployerRequests employer) {
		if(employer.getFirstName()==null || employer.getFirstName().isBlank()||
				employer.getLastName()==null || employer.getLastName().isBlank()||
				employer.getCompanyMail()==null || employer.getCompanyMail().isBlank()||
				employer.getTelephone()==null || employer.getTelephone().isBlank()||
				employer.getCompanyName()==null || employer.getCompanyMail().isBlank()|| 
				employer.getCompanyDescription() ==null || employer.getCompanyDescription().isBlank()){
			return false;
				}
		else {
			return true;
		}
	}

	
	
}
