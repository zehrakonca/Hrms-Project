package io.HrmsProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.JobAdvertisementService;
import io.HrmsProject.business.requests.jobAdvertisementRequests.CreateJobAdvertisementRequests;
import io.HrmsProject.business.requests.jobAdvertisementRequests.UpdateJobAdvertisementRequests;
import io.HrmsProject.business.responses.jobAdvertisementResponses.GetAllJobAdvertisementResponses;
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

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	private SectorDao sectorDao;
	private JobDao jobDao;
	private CityDao cityDao;
	private EmployerDao employerDao;
	
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,SectorDao sectorDao,JobDao jobDao,CityDao cityDao,EmployerDao employerDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.sectorDao = sectorDao;
		this.jobDao = jobDao;
		this.cityDao = cityDao;
		this.employerDao = employerDao;
	}

	@Override
	public Result add(CreateJobAdvertisementRequests createJobAdvertisement) throws Exception {
		JobAdvertisement jobAdvertisement = new JobAdvertisement();
		Sector sector = this.sectorDao.findById(createJobAdvertisement.getSector());
		Job job = this.jobDao.findById(createJobAdvertisement.getJob());
		City city = this.cityDao.findById(createJobAdvertisement.getCity());
		Employer employer = this.employerDao.findById(createJobAdvertisement.getEmployer());
		
		jobAdvertisement.setAdvertisementName(createJobAdvertisement.getAdvertisementName());
		jobAdvertisement.setNumberOfVacancies(createJobAdvertisement.getNumberOfVacancies());
		jobAdvertisement.setJobDescription(createJobAdvertisement.getJobDescription());
		jobAdvertisement.setJobSalaryMin(createJobAdvertisement.getJobSalaryMin());
		jobAdvertisement.setJobSalaryMax(createJobAdvertisement.getJobSalaryMax());
		jobAdvertisement.setReleaseDate(createJobAdvertisement.getReleaseDate().atStartOfDay());
		jobAdvertisement.setApplicationDate(createJobAdvertisement.getApplicationDate());
		jobAdvertisement.setSector(sector);
		jobAdvertisement.setJob(job);
		jobAdvertisement.setCity(city);
		jobAdvertisement.setEmployer(employer);
		jobAdvertisement.setActive(createJobAdvertisement.isActive()==false);;
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("job advertisement has been created. please wait for it to be published.");
		}

	@Override
	public Result update(UpdateJobAdvertisementRequests updateJobAdvertisement, int id) {
		JobAdvertisement jobAdvertisement = jobAdvertisementDao.findById(id);
		
		jobAdvertisement.setJobDescription(updateJobAdvertisement.getJobDescription());
		jobAdvertisement.setNumberOfVacancies(updateJobAdvertisement.getNumberOfVacancies());
		jobAdvertisement.setJobSalaryMax(updateJobAdvertisement.getJobSalaryMax());
		jobAdvertisement.setJobSalaryMin(updateJobAdvertisement.getJobSalaryMin());
		jobAdvertisement.setApplicationDate(updateJobAdvertisement.getApplicationDate());
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
		List<GetAllJobAdvertisementResponses> jobAdvertisementResponses = new ArrayList<GetAllJobAdvertisementResponses>();
		
		for(JobAdvertisement jobAdvertisement : jobAdvertisements) {
			GetAllJobAdvertisementResponses responseItem = new GetAllJobAdvertisementResponses();
			responseItem.setAdvertisementName(jobAdvertisement.getAdvertisementName());
			responseItem.setSector(jobAdvertisement.getSector().getSector());
			responseItem.setJob(jobAdvertisement.getJob().getJobName());
			responseItem.setCity(jobAdvertisement.getCity().getCityName());
			responseItem.setEmployer(jobAdvertisement.getEmployer().getCompanyName());
			responseItem.setNumberOfVacancies(jobAdvertisement.getNumberOfVacancies());
			responseItem.setJobDescription(jobAdvertisement.getJobDescription());
			responseItem.setJobSalaryMin(jobAdvertisement.getJobSalaryMin());
			responseItem.setJobSalaryMax(jobAdvertisement.getJobSalaryMax());
			responseItem.setReleaseDate(jobAdvertisement.getReleaseDate().toLocalDate());
			responseItem.setApplicationDate(jobAdvertisement.getApplicationDate());
			jobAdvertisementResponses.add(responseItem);
			}
		return new SuccessDataResult<List<GetAllJobAdvertisementResponses>>(jobAdvertisementResponses);
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.findById(id));
	}
}
