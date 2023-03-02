package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.highSchoolTypeRequests.CreateHighSchoolTypeRequest;
import io.HrmsProject.business.requests.highSchoolTypeRequests.UpdateHighSchoolTypeRequest;
import io.HrmsProject.business.responses.highSchoolTypeResponses.GetAllHighSchoolTypeResponse;
import io.HrmsProject.business.responses.highSchoolTypeResponses.GetByIdHighSchoolTypeResponse;
import io.HrmsProject.entities.concretes.HighSchoolType;

public interface HighSchoolTypeService extends BaseEntityService<HighSchoolType, CreateHighSchoolTypeRequest, UpdateHighSchoolTypeRequest, GetAllHighSchoolTypeResponse >{
	
	GetByIdHighSchoolTypeResponse getById(int id);
}
