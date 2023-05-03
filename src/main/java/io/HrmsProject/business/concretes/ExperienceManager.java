package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.ExperienceService;
import io.HrmsProject.business.requests.experienceRequests.CreateExperienceRequest;
import io.HrmsProject.business.requests.experienceRequests.UpdateExperienceRequest;
import io.HrmsProject.business.responses.experienceResponses.GetAllExperienceResponse;
import io.HrmsProject.business.responses.experienceResponses.GetByIdExperienceResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.ExperienceDao;
import io.HrmsProject.entities.concretes.Experience;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExperienceManager implements ExperienceService{
	
	private ExperienceDao experienceDao;
	private ModelMapperService modelMapperService;
	
	@Override
	public Result add(CreateExperienceRequest createEntity) throws Exception {
		
		Experience experience = this.modelMapperService.forRequest().map(createEntity, Experience.class);
		this.experienceDao.save(experience);
		return new SuccessResult("experience info has been added.");
	}
	@Override
	public Result update(UpdateExperienceRequest updateEntity) throws Exception {
		Experience experience = this.modelMapperService.forRequest().map(updateEntity, Experience.class);
		this.experienceDao.save(experience);
		return new SuccessResult("experience info has been updated.");
	}
	@Override
	public Result delete(int id) {
		this.experienceDao.deleteById(id);
		return new SuccessResult("experince info deleted");
	}
	@Override
	public DataResult<List<GetAllExperienceResponse>> getAll() {
		List<Experience> experiences = experienceDao.findAll();
		
		List<GetAllExperienceResponse> experienceResponse = experiences.stream().map(experience->this.modelMapperService.forResponse().map(experience, GetAllExperienceResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllExperienceResponse>>(experienceResponse);
	}
	@Override
	public DataResult<GetByIdExperienceResponse> getById(int id) {
		Experience experience = this.experienceDao.findById(id);
		
		GetByIdExperienceResponse response = this.modelMapperService.forResponse().map(experience, GetByIdExperienceResponse.class);
		return new SuccessDataResult<GetByIdExperienceResponse>(response);
	}
	
	

}
