package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.experienceRequests.CreateExperienceRequest;
import io.HrmsProject.business.requests.experienceRequests.UpdateExperienceRequest;
import io.HrmsProject.business.responses.experienceResponses.GetAllExperienceResponse;
import io.HrmsProject.business.responses.experienceResponses.GetByIdExperienceResponse;
import io.HrmsProject.entities.concretes.Experience;

public interface ExperienceService extends BaseEntityService<Experience, CreateExperienceRequest, UpdateExperienceRequest, GetAllExperienceResponse, GetByIdExperienceResponse>{

}
