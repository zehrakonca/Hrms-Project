package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.universityRequests.CreateUniversityRequest;
import io.HrmsProject.business.requests.universityRequests.UpdateUniversityRequest;
import io.HrmsProject.business.responses.universityResponse.GetAllUniversityResponse;
import io.HrmsProject.business.responses.universityResponse.GetByIdUniversityResponse;
import io.HrmsProject.entities.concretes.University;

public interface UniversityService extends BaseEntityService<University, CreateUniversityRequest, UpdateUniversityRequest, GetAllUniversityResponse>{
	GetByIdUniversityResponse getById(int id);

}
