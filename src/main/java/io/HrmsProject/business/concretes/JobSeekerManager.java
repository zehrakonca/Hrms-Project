package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.JobSeekerService;
import io.HrmsProject.business.requests.jobSeekerRequests.CreateJobSeekerRequests;
import io.HrmsProject.business.requests.jobSeekerRequests.UpdateJobSeekerRequest;
import io.HrmsProject.business.responses.jobSeekerResponses.GetAllJobSeekerResponses;
import io.HrmsProject.business.responses.jobSeekerResponses.GetByIdJobSeekerResponse;
import io.HrmsProject.business.responses.jobSeekerResponses.GetByIdentityNumberJobSeekerResponse;
import io.HrmsProject.core.dataAccess.UserStatuDao;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.ErrorResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.JobSeekerDao;
import io.HrmsProject.entities.concretes.JobSeeker;
import io.HrmsProject.entities.concretes.UserStatu;

@Service
public class JobSeekerManager implements JobSeekerService{
	
	private JobSeekerDao jobSeekerDao;
	private UserStatuDao userStatuDao;
	private ModelMapperService modelMapperService;
	
	boolean isExist = false;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,UserStatuDao userStatuDao,ModelMapperService modelMapperService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userStatuDao = userStatuDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateJobSeekerRequests createJobSeekerRequests) {
		JobSeeker jobSeeker = this.modelMapperService.forRequest().map(createJobSeekerRequests, JobSeeker.class);
		
		if(!dataControl(createJobSeekerRequests)) {
			return new ErrorResult("your information is missing. please check your information.");
		}
		else if(isMailExist(createJobSeekerRequests.getMail())){
			return new ErrorResult("your mail already registered. please check your information.");
		}
		else if(isNationalIdentityExist(createJobSeekerRequests.getNationalIdentity())){
			return new ErrorResult("your national identity already registered. please check your information.");
		}
		else if (!createJobSeekerRequests.getPassword().equals(createJobSeekerRequests.getPasswordRep())) {
			return new ErrorResult("these password your entered do not match. please check passwords.");
		}
		else {
			jobSeeker.setActive(createJobSeekerRequests.isActive()==false);
			UserStatu userStatu = this.userStatuDao.findByTypeId(2);
			jobSeeker.setUserStatu(userStatu);
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("jobSeeker has been created. please wait confirmation mail.");
		}
		
	}

	@Override
	public Result update(UpdateJobSeekerRequest updateJobSeekerRequest) {
		JobSeeker jobSeeker = this.modelMapperService.forRequest().map(updateJobSeekerRequest, JobSeeker.class);
		
		if(!isMailExist(updateJobSeekerRequest.getMail())){
			return new ErrorResult("your mail already registered. please check your information.");
		}
		else {
			jobSeeker.setEmail(updateJobSeekerRequest.getMail());
			jobSeeker.setPassword(updateJobSeekerRequest.getPassword());
			jobSeeker.setPasswordRep(updateJobSeekerRequest.getPasswordRep());
			this.jobSeekerDao.save(jobSeeker);
		}
		return new SuccessResult("your information has been updated");
		
	}

	@Override
	public Result delete(int id) {
		this.jobSeekerDao.deleteById(id);
		return new SuccessResult("your account has been deleted.");
	}

	@Override
	public DataResult<List<GetAllJobSeekerResponses>> getAll() {
		List<JobSeeker> jobSeekers = jobSeekerDao.findAll();
		List<GetAllJobSeekerResponses> jobSeekerResponses = jobSeekers.stream().map(jobSeeker->this.modelMapperService.forResponse().map(jobSeeker, GetAllJobSeekerResponses.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllJobSeekerResponses>>(jobSeekerResponses);
	}

	@Override
	public GetByIdJobSeekerResponse getById(int id) {
		JobSeeker jobSeeker = this.jobSeekerDao.findById(id);
		
		GetByIdJobSeekerResponse response = this.modelMapperService.forResponse().map(jobSeeker, GetByIdJobSeekerResponse.class);
		return response;
	}
	
	@Override
	public DataResult<GetByIdentityNumberJobSeekerResponse> getByIdentityNumber(String nationalIdentity) {
		JobSeeker jobSeeker = this.jobSeekerDao.findByNationalIdentity(nationalIdentity);
		
		GetByIdentityNumberJobSeekerResponse response = this.modelMapperService.forResponse().map(jobSeeker, GetByIdentityNumberJobSeekerResponse.class);
		return new SuccessDataResult<GetByIdentityNumberJobSeekerResponse>(response);
		
	}
	
	
	private boolean dataControl(CreateJobSeekerRequests createJobSeekerRequests) {
		if(createJobSeekerRequests.getMail() == null || createJobSeekerRequests.getMail().isBlank()||
		   createJobSeekerRequests.getFirstName() == null || createJobSeekerRequests.getFirstName().isBlank()||
		   createJobSeekerRequests.getLastName()== null || createJobSeekerRequests.getLastName().isBlank()||
		   createJobSeekerRequests.getNationalIdentity()== null || createJobSeekerRequests.getNationalIdentity().isBlank()|| 
		   createJobSeekerRequests.getTelephone()==null || createJobSeekerRequests.getTelephone().isBlank()|| 
		   createJobSeekerRequests.getPassword()==null || createJobSeekerRequests.getPassword().isBlank())
		{
			return false;
		}
		else {
			return true; 
		}
	}
	
	private boolean isMailExist(String mail) {
		List<JobSeeker> jobSeekers = jobSeekerDao.findAll();
		
		for(JobSeeker jobSeeker : jobSeekers) {
			if(jobSeeker.getEmail().equalsIgnoreCase(mail)) {
				isExist = true;
			}
		}
		return isExist;
	}
	
	private boolean isNationalIdentityExist(String nationalIdentity) {
		List<JobSeeker> jobSeekers = jobSeekerDao.findAll();
		
		for(JobSeeker jobSeeker : jobSeekers) {
			if(jobSeeker.getNationalIdentity().equals(nationalIdentity)) {
				isExist = true;
			}
		}
		return isExist;
	}

}
