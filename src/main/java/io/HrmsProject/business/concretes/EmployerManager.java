package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.EmployerService;
import io.HrmsProject.business.requests.employerRequests.CreateEmployerRequests;
import io.HrmsProject.business.requests.employerRequests.UpdateEmployerRequests;
import io.HrmsProject.business.responses.employerResponses.GetAllEmployerResponses;
import io.HrmsProject.business.responses.employerResponses.GetByIdEmployerResponse;
import io.HrmsProject.core.dataAccess.UserStatuDao;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.ErrorResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.core.validations.concretes.MailValidation;
import io.HrmsProject.dataAccess.abstracts.EmployerDao;
import io.HrmsProject.entities.concretes.Employer;
import io.HrmsProject.entities.concretes.JobAdvertisement;
import io.HrmsProject.entities.concretes.UserStatu;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private UserStatuDao userStatuDao;
	private ModelMapperService modelMapperService;
	
	boolean isExist = false;

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserStatuDao userStatuDao,ModelMapperService modelMapperService) {
		super();
		this.employerDao = employerDao;
		this.userStatuDao = userStatuDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateEmployerRequests createEmployerRequests){
		Employer employer = this.modelMapperService.forRequest().map(createEmployerRequests, Employer.class);
		
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
	public Result update(UpdateEmployerRequests updateEmployerRequests){
		
		Employer employer =this.modelMapperService.forRequest().map(updateEmployerRequests, Employer.class);
		
		if(employer.getCompanyName().equalsIgnoreCase(updateEmployerRequests.getCompanyName())) {
			return new ErrorResult("this company name already exist");
		}
		else {
			this.employerDao.save(employer);
		}
		return new SuccessResult("your information has been updated.");
	}
	@Override
		public DataResult<List<GetAllEmployerResponses>> getAll() {
		List<Employer> employers = employerDao.findAll();
		List<GetAllEmployerResponses> employerResponses =employers.stream().map(employer->this.modelMapperService.forResponse().map(employer, GetAllEmployerResponses.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllEmployerResponses>>(employerResponses);
		}
		
	@Override
	public Result delete(int id) {
		this.employerDao.deleteById(id);
		return new SuccessResult("your information has been deleted.");
	}

	

	@Override
	public DataResult<GetByIdEmployerResponse> getById(int id) {
		Employer employer = this.employerDao.findById(id);
		
		GetByIdEmployerResponse response = this.modelMapperService.forResponse().map(employer, GetByIdEmployerResponse.class);
		return new SuccessDataResult<GetByIdEmployerResponse>(response);
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

	@Override
	public DataResult<List<GetAllEmployerResponses>> getAllByIsActive(boolean isActive) {
		List<Employer> employers = employerDao.getByIsActive(isActive);
		List<GetAllEmployerResponses> employerResponses =employers.stream().map(employer->this.modelMapperService.forResponse().map(employer, GetAllEmployerResponses.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllEmployerResponses>>(employerResponses);
	}

	@Override
	public Result makeActiveOrPassive(boolean isActive, int id) {
		String statuMessage = isActive ? "employer has been activated." 
				   : "employer has been passived. ";


		Employer employer = this.employerDao.findById(id);
		employer.setActive(isActive);
		update(employer,id);
		return new SuccessResult(statuMessage);
	}

	@Override
	public Result update(Employer employer, int id) {
		Employer employerupd = this.employerDao.findById(id);
		employerupd.setCompanyDescription(employer.getCompanyDescription());
		employerupd.setCompanyMail(employer.getCompanyMail());
		employerupd.setCompanyName(employer.getCompanyName());
		employerupd.setWebSiteName(employer.getWebSiteName());
		employerupd.setCompanyDescription(employer.getCompanyDescription());
		this.employerDao.save(employerupd);
		return new SuccessResult();
	}
	
}
