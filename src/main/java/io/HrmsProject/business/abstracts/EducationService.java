package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.business.requests.educationRequests.CreateEducationRequests;
import io.HrmsProject.business.requests.educationRequests.UpdateEducationRequests;
import io.HrmsProject.business.responses.educationResponses.GetAllEducationResponses;
import io.HrmsProject.business.responses.educationResponses.GetByIdEducationResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.Education;

public interface EducationService extends BaseEntityService<Education, CreateEducationRequests, UpdateEducationRequests, GetAllEducationResponses>{

	DataResult<List<Education>> getAllBySortedGraduationDate(int educationId);
	
	DataResult<GetByIdEducationResponse> getByEducationId(int id);
}
