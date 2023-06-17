package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.business.requests.jobApplicationRequests.CreateJobApplicationRequest;
import io.HrmsProject.business.requests.jobApplicationRequests.UpdateJobApplicationRequest;
import io.HrmsProject.business.responses.jobApplicationResponses.GetAllJobApplicationResponse;
import io.HrmsProject.business.responses.jobApplicationResponses.GetByEmployerIdJobApplicationResponse;
import io.HrmsProject.business.responses.jobApplicationResponses.GetByIdJobApplicationResponse;
import io.HrmsProject.business.responses.jobApplicationResponses.GetByJobSeekerIdJobApplicationResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.JobApplication;

public interface JobApplicationService extends BaseEntityService<JobApplication, CreateJobApplicationRequest, UpdateJobApplicationRequest, GetAllJobApplicationResponse, GetByIdJobApplicationResponse>{
	
	DataResult<List<GetByEmployerIdJobApplicationResponse>> getByEmployerId(int employerId);
	
	DataResult<List<GetByJobSeekerIdJobApplicationResponse>> getByJobSeekerId(int jobSeeker);

}
