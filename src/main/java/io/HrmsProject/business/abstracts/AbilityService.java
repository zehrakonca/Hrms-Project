package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.abilityRequests.CreateAbilityRequests;
import io.HrmsProject.business.requests.abilityRequests.UpdateAbilityRequests;
import io.HrmsProject.business.responses.abilityResponses.GetAllAbilityResponses;
import io.HrmsProject.business.responses.abilityResponses.GetByIdAbilityResponse;
import io.HrmsProject.entities.concretes.Ability;

public interface AbilityService extends BaseEntityService<Ability, CreateAbilityRequests, UpdateAbilityRequests, GetAllAbilityResponses>{
	
	GetByIdAbilityResponse getById(int id);

}
