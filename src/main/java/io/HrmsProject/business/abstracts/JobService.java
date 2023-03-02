package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.business.requests.jobRequests.CreateJobRequests;
import io.HrmsProject.business.requests.jobRequests.UpdateJobRequests;
import io.HrmsProject.business.responses.jobResponses.GetAllJobResponses;
import io.HrmsProject.business.responses.jobResponses.GetByIdJobResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.Job;

public interface JobService extends BaseEntityService<Job, CreateJobRequests, UpdateJobRequests, GetAllJobResponses>{
	
	public DataResult<List<Job>> getByNameAndSector(String jobName, int sectorId);
	public DataResult<List<Job>> getBySectorId(int sectorId);
	GetByIdJobResponse getById(int id);
}
