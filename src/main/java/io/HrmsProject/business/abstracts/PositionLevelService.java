package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.positionLevelRequests.CreatePositionLevelRequest;
import io.HrmsProject.business.requests.positionLevelRequests.UpdatePositionLevelRequest;
import io.HrmsProject.business.responses.positionLevelResponses.GetAllPositionLevelResponse;
import io.HrmsProject.business.responses.positionLevelResponses.GetByIdPositionLevelResponse;
import io.HrmsProject.entities.concretes.PositionLevel;

public interface PositionLevelService extends BaseEntityService<PositionLevel, CreatePositionLevelRequest, UpdatePositionLevelRequest, GetAllPositionLevelResponse, GetByIdPositionLevelResponse> {
	
	

}
