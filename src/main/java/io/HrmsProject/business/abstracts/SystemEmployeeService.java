package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.systemEmployeeRequests.CreateSystemEmployeeRequest;
import io.HrmsProject.business.requests.systemEmployeeRequests.UpdateSystemEmployeeRequest;
import io.HrmsProject.business.responses.systemEmployeeResponses.GetAllSystemEmployeeResponse;
import io.HrmsProject.business.responses.systemEmployeeResponses.GetByIdSystemEmployeeResponse;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.entities.concretes.SystemEmployee;

public interface SystemEmployeeService extends BaseEntityService<SystemEmployee, CreateSystemEmployeeRequest, UpdateSystemEmployeeRequest, GetAllSystemEmployeeResponse, GetByIdSystemEmployeeResponse>{
	
	Result makeActiveOrPassive(boolean isActive, int id);
	Result update(SystemEmployee systemEmployee, int id);

}
