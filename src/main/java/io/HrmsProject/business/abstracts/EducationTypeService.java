package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.educationTypeRequests.CreateEducationTypeRequests;
import io.HrmsProject.business.requests.educationTypeRequests.UpdateEducationTypeRequests;
import io.HrmsProject.business.responses.educationTypeResponses.GetAllEducationTypeResponses;
import io.HrmsProject.business.responses.educationTypeResponses.GetByEducationTypeIdResponses;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.EducationType;

public interface EducationTypeService extends BaseEntityService<EducationType, CreateEducationTypeRequests, UpdateEducationTypeRequests, GetAllEducationTypeResponses>{
	DataResult<GetByEducationTypeIdResponses> getById(int id);
}
