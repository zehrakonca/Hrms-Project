package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.JobService;
import io.HrmsProject.business.requests.jobRequests.CreateJobRequests;
import io.HrmsProject.business.requests.jobRequests.UpdateJobRequests;
import io.HrmsProject.business.responses.jobResponses.GetAllJobResponses;
import io.HrmsProject.business.responses.jobResponses.GetByIdJobResponse;
import io.HrmsProject.business.responses.jobResponses.GetByJobNameAndSectorResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.ErrorResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.JobDao;
import io.HrmsProject.dataAccess.abstracts.SectorDao;
import io.HrmsProject.entities.concretes.Job;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobManager implements JobService{
	
	private JobDao jobDao;
	private SectorDao sectorDao;
	private ModelMapperService modelMapperService;

	@Override
	public Result add(CreateJobRequests createJobRequests) {
		
		Job job =this.modelMapperService.forRequest().map(createJobRequests, Job.class);
		System.out.println(createJobRequests);
		if((createJobRequests.getJobName().isEmpty())) {
			return  new ErrorResult("job information cannot be blank.");
		}
		else if(isJobExist(createJobRequests.getJobName())) {
			return new ErrorResult("this job information already in list.");
		}
		else {
			this.jobDao.save(job);
			return new SuccessResult("job information has been added.");
		}
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
	public DataResult<GetByIdJobResponse> getById(int id) {
		Job job = this.jobDao.findById(id);
		
		GetByIdJobResponse response = this.modelMapperService.forResponse().map(job, GetByIdJobResponse.class);
		return new SuccessDataResult<GetByIdJobResponse>(response);
	}
	
	private boolean isJobExist(String jobName){
		List<Job> jobs = jobDao.findAll();
		
		for(Job job : jobs) {
			if(job.getJobName().equalsIgnoreCase(jobName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public DataResult<List<GetByJobNameAndSectorResponse>> getByNameAndSector(String jobName) {
		List<Job> jobs = this.jobDao.findByJobNameContainsIgnoreCase(jobName);
		
List<GetByJobNameAndSectorResponse> jobsResponse = jobs.stream().map(job->this.modelMapperService.forResponse().map(job, GetByJobNameAndSectorResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetByJobNameAndSectorResponse>>(jobsResponse);
	}



}
