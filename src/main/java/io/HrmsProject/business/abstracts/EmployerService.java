package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.employerRequests.CreateEmployerRequests;
import io.HrmsProject.business.requests.employerRequests.UpdateEmployerRequests;
import io.HrmsProject.business.responses.employerResponses.GetAllEmployerResponses;
import io.HrmsProject.business.responses.employerResponses.GetByIdEmployerResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.Employer;

public interface EmployerService extends BaseEntityService<Employer,CreateEmployerRequests, UpdateEmployerRequests, GetAllEmployerResponses>{
	
	DataResult<GetByIdEmployerResponse> getByEmployerId(int id);

}
