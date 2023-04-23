package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.business.requests.jobRequests.CreateJobRequests;
import io.HrmsProject.business.requests.jobRequests.UpdateJobRequests;
import io.HrmsProject.business.responses.jobResponses.GetAllJobResponses;
import io.HrmsProject.business.responses.jobResponses.GetByIdJobResponse;
import io.HrmsProject.business.responses.jobResponses.GetByIdSectorJobResponse;
import io.HrmsProject.business.responses.jobResponses.GetByJobNameAndSectorResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.Job;

public interface JobService extends BaseEntityService<Job, CreateJobRequests, UpdateJobRequests, GetAllJobResponses,GetByIdJobResponse>{
	
	DataResult<List<GetByJobNameAndSectorResponse>> getByNameAndSector(String jobName);
	DataResult<List<GetByIdSectorJobResponse>> getBySectorId(int sectorId);
}
