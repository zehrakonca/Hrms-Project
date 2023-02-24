package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.business.requests.jobExperienceRequests.CreateJobExperienceRequests;
import io.HrmsProject.business.requests.jobExperienceRequests.UpdateJobExperienceRequests;
import io.HrmsProject.business.responses.jobExperienceResponses.GetAllJobExperienceResponses;
import io.HrmsProject.business.responses.jobExperienceResponses.GetByJobSeekerIdResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.JobExperience;

public interface JobExperienceService extends BaseEntityService<JobExperience, CreateJobExperienceRequests, UpdateJobExperienceRequests, GetAllJobExperienceResponses>{

	DataResult<List<JobExperience>> getByJobSeekerId(int jobSeekerId);
	DataResult<GetByJobSeekerIdResponse> getByJobSeekerIdResponse(int jobSeekerId);
}
