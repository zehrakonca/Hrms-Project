package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.business.requests.employerRequests.CreateEmployerRequests;
import io.HrmsProject.business.requests.employerRequests.UpdateEmployerRequests;
import io.HrmsProject.business.responses.employerResponses.GetAllEmployerResponses;
import io.HrmsProject.business.responses.employerResponses.GetByIdEmployerResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.Employer;

public interface EmployerService extends BaseEntityService<Employer,CreateEmployerRequests, UpdateEmployerRequests, GetAllEmployerResponses>{

	DataResult<GetByIdEmployerResponse>  getById(int id);
	
	DataResult<List<GetAllEmployerResponses>> getAllByIsActive(boolean isActive);
}
