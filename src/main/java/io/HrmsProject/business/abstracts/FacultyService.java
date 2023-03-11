package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.facultyRequests.CreateFacultyRequests;
import io.HrmsProject.business.requests.facultyRequests.UpdateFacultyRequests;
import io.HrmsProject.business.responses.facultyResponses.GetAllFacultyResponse;
import io.HrmsProject.business.responses.facultyResponses.GetByIdFacultyResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.Faculty;

public interface FacultyService extends BaseEntityService<Faculty, CreateFacultyRequests, UpdateFacultyRequests, GetAllFacultyResponse >{
	
	DataResult<GetByIdFacultyResponse> getById(int id);

}
