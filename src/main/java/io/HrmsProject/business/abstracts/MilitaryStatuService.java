package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.militaryStatuRequests.CreateMilitaryStatuRequest;
import io.HrmsProject.business.requests.militaryStatuRequests.UpdateMilitaryStatuRequest;
import io.HrmsProject.business.responses.militaryStatuResponses.GetAllMilitaryStatuResponse;
import io.HrmsProject.business.responses.militaryStatuResponses.GetByIdMilitaryStatuResponse;
import io.HrmsProject.entities.concretes.MilitaryStatu;

public interface MilitaryStatuService extends BaseEntityService<MilitaryStatu, CreateMilitaryStatuRequest, UpdateMilitaryStatuRequest, GetAllMilitaryStatuResponse, GetByIdMilitaryStatuResponse> {

}
