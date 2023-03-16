package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.JobAdvertisementService;
import io.HrmsProject.business.requests.jobAdvertisementRequests.CreateJobAdvertisementRequests;
import io.HrmsProject.business.requests.jobAdvertisementRequests.UpdateJobAdvertisementRequests;
import io.HrmsProject.business.responses.jobAdvertisementResponses.GetAllJobAdvertisementResponses;
import io.HrmsProject.business.responses.jobAdvertisementResponses.GetByIdJobAdvertisementResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.CityDao;
import io.HrmsProject.dataAccess.abstracts.EmployerDao;
import io.HrmsProject.dataAccess.abstracts.JobAdvertisementDao;
import io.HrmsProject.dataAccess.abstracts.JobDao;
import io.HrmsProject.dataAccess.abstracts.SectorDao;
import io.HrmsProject.entities.concretes.City;
import io.HrmsProject.entities.concretes.Employer;
import io.HrmsProject.entities.concretes.Job;
import io.HrmsProject.entities.concretes.JobAdvertisement;
import io.HrmsProject.entities.concretes.Sector;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	private SectorDao sectorDao;
	private JobDao jobDao;
	private CityDao cityDao;
	private EmployerDao employerDao;
	private ModelMapperService modelMapperService;
	
	@Override
	public Result add(CreateJobAdvertisementRequests createJobAdvertisement) throws Exception {
		JobAdvertisement jobAdvertisement =this.modelMapperService.forRequest().map(createJobAdvertisement, JobAdvertisement.class);
		Sector sector = this.sectorDao.findById(createJobAdvertisement.getSector());
		City city = this.cityDao.findById(createJobAdvertisement.getCity());
		Employer employer = this.employerDao.findById(createJobAdvertisement.getEmployer());
		Job job = this.jobDao.findById(createJobAdvertisement.getJob());
		
		jobAdvertisement.setReleaseDate(createJobAdvertisement.getReleaseDate().atStartOfDay());	
		jobAdvertisement.setSector(sector);
		jobAdvertisement.setCity(city);
		jobAdvertisement.setEmployer(employer);
		jobAdvertisement.setJob(job);
		jobAdvertisement.setActive(createJobAdvertisement.isActive()==false);;
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("job advertisement has been created. please wait for it to be published.");
		}

	@Override
	public Result update(UpdateJobAdvertisementRequests updateJobAdvertisement) {
		JobAdvertisement jobAdvertisement = this.modelMapperService.forRequest().map(updateJobAdvertisement, JobAdvertisement.class);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("job advertisement has been updated.");
	}
	
	@Override
	public Result update(JobAdvertisement jobAdvertisement,int id) {
		JobAdvertisement advertisement = jobAdvertisementDao.findById(id);
		advertisement.setJobDescription(jobAdvertisement.getJobDescription());
		advertisement.setNumberOfVacancies(jobAdvertisement.getNumberOfVacancies());
		advertisement.setJobSalaryMax(jobAdvertisement.getJobSalaryMax());
		advertisement.setJobSalaryMin(jobAdvertisement.getJobSalaryMin());
		advertisement.setApplicationDate(jobAdvertisement.getApplicationDate());
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("job advertisement has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertisementDao.deleteById(id);
		return new SuccessResult("job advertisement has been deleted.");
	}

	@Override
	public DataResult<List<GetAllJobAdvertisementResponses>> getAll() {
		List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAll();
		List<GetAllJobAdvertisementResponses> jobAdvertisementResponses = jobAdvertisements.stream().map(jobAdvertisement->this.modelMapperService.forResponse().map(jobAdvertisement, GetAllJobAdvertisementResponses.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllJobAdvertisementResponses>>(jobAdvertisementResponses);
	}


	@Override
	public Result makeActiveOrPassive(boolean isActive, int advertisementId) {
		
		String statuMessage = isActive ? "advertisement has been activated." 
									   : "advertisement has been passived. ";
		
		
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(advertisementId);
		jobAdvertisement.setActive(isActive);
		update(jobAdvertisement, advertisementId);
		return new SuccessResult(statuMessage);
		}

	@Override
	public DataResult<List<GetAllJobAdvertisementResponses>> getAllByIsActive(boolean isActive) {
		List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.getByIsActive(isActive);
		List<GetAllJobAdvertisementResponses> jobAdvertisementResponses = jobAdvertisements.stream().map(jobAdvertisement->this.modelMapperService.forResponse().map(jobAdvertisement, GetAllJobAdvertisementResponses.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllJobAdvertisementResponses>>(jobAdvertisementResponses);
	}

	@Override
	public DataResult<List<GetAllJobAdvertisementResponses>> getJobAdvertisementDetailSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "applicationDate");
		List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAll(sort);
		List<GetAllJobAdvertisementResponses> response = jobAdvertisements.stream().map(jobAdvertisement->this.modelMapperService.forResponse().map(jobAdvertisement, GetAllJobAdvertisementResponses.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllJobAdvertisementResponses>>(response);
	}

	@Override
	public DataResult<List<GetAllJobAdvertisementResponses>> getByIsActiveAndEmployerId(boolean isActive,int employerId) {
		Sort sort = Sort.by(Sort.Direction.DESC, "applicationDate");
		List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.getByIsActiveAndEmployer_Id(true, employerId, sort);
		List<GetAllJobAdvertisementResponses> response = jobAdvertisements.stream().map(jobAdvertisement->this.modelMapperService.forResponse().map(jobAdvertisement, GetAllJobAdvertisementResponses.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllJobAdvertisementResponses>>(response);
	}

	@Override
	public DataResult<List<GetAllJobAdvertisementResponses>> getByCompanyName(String companyName,boolean isActive) {
		Sort sort = Sort.by(Sort.Direction.DESC, "applicationDate");
		List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findByEmployer_CompanyNameAndIsActive(companyName,sort,isActive);
		List<GetAllJobAdvertisementResponses> response = jobAdvertisements.stream().map(jobAdvertisement->this.modelMapperService.forResponse().map(jobAdvertisement, GetAllJobAdvertisementResponses.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllJobAdvertisementResponses>>(response);
}

	@Override
	public DataResult<GetByIdJobAdvertisementResponse> getById(int id) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(id);
		
		GetByIdJobAdvertisementResponse response = this.modelMapperService.forResponse().map(jobAdvertisement, GetByIdJobAdvertisementResponse.class);
		return new SuccessDataResult<GetByIdJobAdvertisementResponse>(response);
		
	}

	@Override
	public DataResult<List<GetAllJobAdvertisementResponses>> getAllByJobAdvertisementName(String advertisementName) {
		Sort sort = Sort.by(Sort.Direction.DESC, "applicationDate");
		List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findByAdvertisementNameContainsIgnoreCase(advertisementName, sort);
		List<GetAllJobAdvertisementResponses> response = jobAdvertisements.stream().map(jobAdvertisement->this.modelMapperService.forResponse().map(jobAdvertisement, GetAllJobAdvertisementResponses.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllJobAdvertisementResponses>>(response);
	}
	
	
}
