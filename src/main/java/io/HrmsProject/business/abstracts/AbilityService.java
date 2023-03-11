package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.business.requests.abilityRequests.CreateAbilityRequests;
import io.HrmsProject.business.requests.abilityRequests.UpdateAbilityRequests;
import io.HrmsProject.business.responses.abilityResponses.GetAllAbilityResponses;
import io.HrmsProject.business.responses.abilityResponses.GetByIdAbilityResponse;
import io.HrmsProject.business.responses.abilityResponses.GetByIdJobSeekerAbilityResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.Ability;

public interface AbilityService extends BaseEntityService<Ability, CreateAbilityRequests, UpdateAbilityRequests, GetAllAbilityResponses>{
	
	DataResult<GetByIdAbilityResponse> getById(int id);

	DataResult<List<GetByIdJobSeekerAbilityResponse>> getByJobSeekerId(int jobSeekerId);
}
