package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.highSchoolRequests.CreateHighSchoolInfoRequests;
import io.HrmsProject.business.requests.highSchoolRequests.UpdateHighSchoolInfoRequests;
import io.HrmsProject.business.responses.highSchoolResponses.GetAllHighSchoolResponses;
import io.HrmsProject.business.responses.highSchoolResponses.GetByIdHighSchoolResponse;
import io.HrmsProject.business.responses.highSchoolResponses.GetByJobSeekerIdResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.HighSchool;

public interface HighSchoolService extends BaseEntityService<HighSchool, CreateHighSchoolInfoRequests, UpdateHighSchoolInfoRequests, GetAllHighSchoolResponses,GetByIdHighSchoolResponse>{
	
	DataResult<GetByJobSeekerIdResponse> getByJobSeekerId(int jobSeekerId);
}
