package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.jobSeekerRequests.CreateJobSeekerRequests;
import io.HrmsProject.business.requests.jobSeekerRequests.UpdateJobSeekerRequest;
import io.HrmsProject.business.responses.jobSeekerResponses.GetAllJobSeekerResponses;
import io.HrmsProject.business.responses.jobSeekerResponses.GetByIdJobSeekerResponse;
import io.HrmsProject.business.responses.jobSeekerResponses.GetByIdentityNumberJobSeekerResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.entities.concretes.JobSeeker;

public interface JobSeekerService extends BaseEntityService<JobSeeker, CreateJobSeekerRequests, UpdateJobSeekerRequest, GetAllJobSeekerResponses,GetByIdJobSeekerResponse>{
	
	DataResult<GetByIdentityNumberJobSeekerResponse> getByIdentityNumber(String nationalIdentity);	
	Result makeActiveOrPassive(boolean isActive, int id);
	Result update(JobSeeker jobSeeker, int id);
	
//	void add(CreateJobSeekerRequests createJobSeekerRequests);
//	void update(UpdateJobSeekerRequest jobSeekerRequest);
//	void getAll(GetAllJobSeekerResponses getAllJobSeekerResponses);
//	void getById(GetByIdJobSeekerResponse getByIdJobSeekerResponse);
}