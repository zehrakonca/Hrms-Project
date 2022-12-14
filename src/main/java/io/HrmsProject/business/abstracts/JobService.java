package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.business.requests.jobRequests.CreateJobRequests;
import io.HrmsProject.business.requests.jobRequests.UpdateJobRequests;
import io.HrmsProject.business.responses.jobResponses.GetAllJobResponses;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.Job;

public interface JobService {
	
	void add(CreateJobRequests createJobRequests)throws Exception;
	void update(UpdateJobRequests updateJobRequests,int id)throws Exception;
	void delete(int id);
	
	public List<GetAllJobResponses> getAll();
	
	public Job getById(int id);
	
	public DataResult<List<Job>> getByNameAndSector(String jobName, int sectorId);
	public DataResult<List<Job>> getBySectorId(int sectorId);
	
}
