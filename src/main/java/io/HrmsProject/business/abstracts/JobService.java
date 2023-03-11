package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.jobRequests.CreateJobRequests;
import io.HrmsProject.business.requests.jobRequests.UpdateJobRequests;
import io.HrmsProject.business.responses.jobResponses.GetAllJobResponses;
import io.HrmsProject.business.responses.jobResponses.GetByIdJobResponse;
import io.HrmsProject.business.responses.jobResponses.GetByIdSectorJobResponse;
import io.HrmsProject.business.responses.jobResponses.GetByJobNameAndSectorResponse;
import io.HrmsProject.entities.concretes.Job;

public interface JobService extends BaseEntityService<Job, CreateJobRequests, UpdateJobRequests, GetAllJobResponses>{
	
	GetByJobNameAndSectorResponse getByNameAndSector(String jobName);
	GetByIdSectorJobResponse getBySectorId(int sectorId);
	GetByIdJobResponse getById(int id);
}
