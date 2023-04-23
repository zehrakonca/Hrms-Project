package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.typeOfWorkRequests.CreateTypeOfWorkRequest;
import io.HrmsProject.business.requests.typeOfWorkRequests.UpdateTypeOfWorkRequest;
import io.HrmsProject.business.responses.typeOfworkResponses.GetAllTypeOfWorkResponse;
import io.HrmsProject.business.responses.typeOfworkResponses.GetByIdTypeOfWorkResponse;
import io.HrmsProject.entities.concretes.TypeOfWork;

public interface TypeOfWorkService extends BaseEntityService<TypeOfWork, CreateTypeOfWorkRequest, UpdateTypeOfWorkRequest, GetAllTypeOfWorkResponse,GetByIdTypeOfWorkResponse>{
	
	
	

}
