package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.AbilityService;
import io.HrmsProject.business.requests.abilityRequests.CreateAbilityRequests;
import io.HrmsProject.business.requests.abilityRequests.UpdateAbilityRequests;
import io.HrmsProject.business.responses.abilityResponses.GetAllAbilityResponses;
import io.HrmsProject.business.responses.abilityResponses.GetByIdAbilityResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.AbilityDao;
import io.HrmsProject.dataAccess.abstracts.JobSeekerDao;
import io.HrmsProject.entities.concretes.Ability;
import io.HrmsProject.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AbilityManager implements AbilityService {
	
	private ModelMapperService modelMapperService;
	private AbilityDao abilityDao;
	private JobSeekerDao jobSeekerDao;
	
	@Override
	public Result add(CreateAbilityRequests createEntity) throws Exception {
		Ability ability = this.modelMapperService.forRequest().map(createEntity, Ability.class);
		JobSeeker jobSeeker = this.jobSeekerDao.findById(createEntity.getJobSeeker());
		
		ability.setJobSeeker(jobSeeker);
		this.abilityDao.save(ability);
		return new SuccessResult("your ability has been saved.");
		
	}

	@Override
	public Result update(UpdateAbilityRequests updateEntity) {
		Ability ability = this.modelMapperService.forRequest().map(updateEntity, Ability.class);
		this.abilityDao.save(ability);
		return new SuccessResult("ability has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.abilityDao.deleteById(id);
		return new SuccessResult("ability has been deleted.");
	}

	@Override
	public DataResult<List<GetAllAbilityResponses>> getAll() {
		List<Ability> abilities = this.abilityDao.findAll();
		List<GetAllAbilityResponses> abilityResponses = abilities.stream().map(ability->this.modelMapperService.forResponse().map(ability, GetAllAbilityResponses.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllAbilityResponses>>(abilityResponses);
	}

	@Override
	public GetByIdAbilityResponse getById(int id) {
		
		Ability ability = this.abilityDao.findById(id);
		
		GetByIdAbilityResponse response = this.modelMapperService.forResponse().map(ability, GetByIdAbilityResponse.class);
		return response;
		
	}

}
