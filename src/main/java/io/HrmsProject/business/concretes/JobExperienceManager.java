package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.JobExperienceService;
import io.HrmsProject.business.requests.jobExperienceRequests.CreateJobExperienceRequests;
import io.HrmsProject.business.requests.jobExperienceRequests.UpdateJobExperienceRequests;
import io.HrmsProject.business.responses.jobExperienceResponses.GetAllJobExperienceResponses;
import io.HrmsProject.business.responses.jobExperienceResponses.GetByIdJobExperienceResponse;
import io.HrmsProject.business.responses.jobExperienceResponses.GetByJobSeekerIdResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.CityDao;
import io.HrmsProject.dataAccess.abstracts.JobExperienceDao;
import io.HrmsProject.dataAccess.abstracts.JobSeekerDao;
import io.HrmsProject.dataAccess.abstracts.SectorDao;
import io.HrmsProject.entities.concretes.City;
import io.HrmsProject.entities.concretes.JobExperience;
import io.HrmsProject.entities.concretes.JobSeeker;
import io.HrmsProject.entities.concretes.Sector;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobExperienceManager implements JobExperienceService{
	
	private CityDao cityDao;
	private JobSeekerDao jobSeekerDao;
	private JobExperienceDao jobExperienceDao;
	private SectorDao sectorDao;
	private ModelMapperService modelMapperService;

	@Override
	public Result add(CreateJobExperienceRequests createEntity) throws Exception {
		JobExperience jobExperience = this.modelMapperService.forRequest().map(createEntity, JobExperience.class);
		City city = this.cityDao.findById(createEntity.getCity());
		JobSeeker jobSeeker = this.jobSeekerDao.findById(createEntity.getJobSeeker());
		Sector sector = this.sectorDao.findById(createEntity.getSector())
;		
		
		jobExperience.setCity(city);
		jobExperience.setJobSeeker(jobSeeker);
		jobExperience.setSector(sector);
		
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("your job experience information has been saved.");
	}

	@Override
	public Result update(UpdateJobExperienceRequests updateEntity) {
		JobExperience jobExperience = this.modelMapperService.forRequest().map(updateEntity, JobExperience.class);
		City city = this.cityDao.findById(updateEntity.getCity());
		JobSeeker jobSeeker = this.jobSeekerDao.findById(updateEntity.getJobSeeker());
		Sector sector = this.sectorDao.findById(updateEntity.getSector())
;		
		
		jobExperience.setCity(city);
		jobExperience.setJobSeeker(jobSeeker);
		jobExperience.setSector(sector);
		
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("your job experience information has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.jobExperienceDao.deleteById(id);
		return new SuccessResult("your job information has been deleted.");
	}

	@Override
	public DataResult<List<GetAllJobExperienceResponses>> getAll() {
		List<JobExperience> jobExperiences = this.jobExperienceDao.findAll();
		List<GetAllJobExperienceResponses> jobExperienceResponses = jobExperiences.stream().map(jobExperience->this.modelMapperService.forResponse().map(jobExperience, GetAllJobExperienceResponses.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllJobExperienceResponses>>(jobExperienceResponses);
	}

	@Override
	public GetByIdJobExperienceResponse getById(int id) {
		JobExperience jobExperience = this.jobExperienceDao.findById(id);
		
		GetByIdJobExperienceResponse response = this.modelMapperService.forResponse().map(jobExperience, GetByIdJobExperienceResponse.class);
		return response;
	}

	@Override
	public DataResult<GetByJobSeekerIdResponse> getByJobSeekerIdResponse(int jobSeekerId) {
		List<JobExperience> jobExperience = this.jobExperienceDao.getByJobSeeker_Id(jobSeekerId);
		
		GetByJobSeekerIdResponse response = this.modelMapperService.forResponse().map(jobExperience, GetByJobSeekerIdResponse.class);
		
		return new SuccessDataResult<GetByJobSeekerIdResponse>(response);
	}
	
	@Override
	public DataResult<GetByJobSeekerIdResponse> getAllBySortedEndDate(int jobSeekerId) {
		Sort sort = Sort.by(Sort.Direction.DESC,"endDate");
		
		List<JobExperience> jobExperience = this.jobExperienceDao.getByJobSeeker_Id(jobSeekerId, sort);
		
		GetByJobSeekerIdResponse response = this.modelMapperService.forResponse().map(jobExperience, GetByJobSeekerIdResponse.class);
		return new SuccessDataResult<GetByJobSeekerIdResponse>(response);
	}

}
