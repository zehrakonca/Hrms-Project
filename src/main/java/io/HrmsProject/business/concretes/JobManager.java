package io.HrmsProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.JobService;
import io.HrmsProject.business.requests.jobRequests.CreateJobRequests;
import io.HrmsProject.business.requests.jobRequests.UpdateJobRequests;
import io.HrmsProject.business.responses.jobResponses.GetAllJobResponses;
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
	
	boolean isExist = false;
	
	@Autowired
	public JobManager(JobDao jobDao, SectorDao sectorDao) {
		super();
		this.jobDao = jobDao;
		this.sectorDao = sectorDao;
	}

	@Override
	public Result add(CreateJobRequests createJobRequests) {
		
		Job job = new Job();
		job.setJobName(createJobRequests.getJob());
		
		if(job.getJobName()==null || createJobRequests.getJob().isEmpty()) {
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
	public Result update(UpdateJobRequests updateJobRequests, int id){
		
		Job job = jobDao.findById(id);
		
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
		List<GetAllJobResponses> jobResponses = new ArrayList<GetAllJobResponses>();
		
		for(Job job : jobs) {
			GetAllJobResponses responseItem = new GetAllJobResponses();
			responseItem.setId(job.getJobId());
			responseItem.setJob(job.getJobName());
			responseItem.setSectorName(job.getSector().getSector());
			jobResponses.add(responseItem);
		}
		return new SuccessDataResult<List<GetAllJobResponses>>("job has been created.");
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
