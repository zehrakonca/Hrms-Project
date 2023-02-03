package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.highSchool.CreateHighSchoolInfoRequests;
import io.HrmsProject.business.requests.highSchool.UpdateHighSchoolInfoRequests;
import io.HrmsProject.business.responses.highSchoolResponses.GetAllHighSchoolResponses;
import io.HrmsProject.entities.concretes.HighSchool;

public interface HighSchoolService extends BaseEntityService<HighSchool, CreateHighSchoolInfoRequests, UpdateHighSchoolInfoRequests, GetAllHighSchoolResponses>{
	
	

}
