package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.programRequests.CreateProgramRequest;
import io.HrmsProject.business.requests.programRequests.UpdateProgramRequest;
import io.HrmsProject.business.responses.programResponses.GetAllProgramResponse;
import io.HrmsProject.business.responses.programResponses.GetByIdProgramResponse;
import io.HrmsProject.entities.concretes.ProgramInfo;

public interface ProgramInfoService extends BaseEntityService<ProgramInfo, CreateProgramRequest, UpdateProgramRequest, GetAllProgramResponse >{

	GetByIdProgramResponse getById(int id);
}
