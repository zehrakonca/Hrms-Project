package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.JobService;
import io.HrmsProject.business.requests.jobRequests.CreateJobRequests;
import io.HrmsProject.business.requests.jobRequests.UpdateJobRequests;
import io.HrmsProject.business.responses.jobResponses.GetAllJobResponses;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.ErrorResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.JobDao;
import io.HrmsProject.dataAccess.abstracts.SectorDao;
import io.HrmsProject.entities.concretes.Job;
import io.HrmsProject.entities.concretes.Sector;

@Service
public class JobManager implements JobService{
	
	private JobDao jobDao;
	private SectorDao sectorDao;
	private ModelMapperService modelMapperService;
	
	boolean isExist = false;
	
	@Autowired
	public JobManager(JobDao jobDao, SectorDao sectorDao,ModelMapperService modelMapperService) {
		super();
		this.jobDao = jobDao;
		this.sectorDao = sectorDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateJobRequests createJobRequests) {
		
		Job job =this.modelMapperService.forRequest().map(createJobRequests, Job.class);
		
		if(!(job.getJobName()==null || createJobRequests.getJob().isEmpty())) {
			return  new ErrorResult("job information cannot be blank.");
		}
		else if(isJobExist(createJobRequests.getJob())) {
			return new ErrorResult("this job information already in list.");
		}
		else {
			Sector sector = sectorDao.findById(createJobRequests.getSectorId());
			job.setSector(sector);
			this.jobDao.save(job);
		}
		return new SuccessResult("job information has been added.");
	}

	@Override
	public Result update(UpdateJobRequests updateJobRequests){
		
		Job job = this.modelMapperService.forRequest().map(updateJobRequests, Job.class);
		
		if(isJobExist(updateJobRequests.getJob())) {
			return new ErrorResult("job information already in list.");
		}
		else {
			job.setJobName(updateJobRequests.getJob());
			this.jobDao.save(job);
		}
		return new SuccessResult("job information has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.jobDao.deleteById(id);
		return new SuccessResult("job has been deleted.");
	}

	@Override
	public DataResult<List<GetAllJobResponses>> getAll() {
		List<Job> jobs = jobDao.findAll();
		List<GetAllJobResponses> jobResponse = jobs.stream().map(job->this.modelMapperService.forResponse().map(job, GetAllJobResponses.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllJobResponses>>(jobResponse,"job has been listed.");
	}

	@Override
	public DataResult<Job> getById(int id) {
		return new SuccessDataResult<Job>(this.jobDao.findById(id));
	}
	
	private boolean isJobExist(String jobName){
		List<Job> jobs = jobDao.findAll();
		
		for(Job job : jobs ) {
			if(job.getJobName().equalsIgnoreCase(jobName)) {
				isExist = true;
			}
		}
		return isExist;
	}

	@Override
	public DataResult<List<Job>> getByNameAndSector(String jobName, int sectorId) {
		return new SuccessDataResult<List<Job>>(this.jobDao.getByNameAndSector(jobName, sectorId));
	}

	@Override
	public DataResult<List<Job>>getBySectorId(int sectorId) {
		return new SuccessDataResult<List<Job>>(this.jobDao.getBySector(sectorId));
	}

}
