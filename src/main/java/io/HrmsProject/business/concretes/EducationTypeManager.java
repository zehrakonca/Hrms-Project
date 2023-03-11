package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.EducationTypeService;
import io.HrmsProject.business.requests.educationTypeRequests.CreateEducationTypeRequests;
import io.HrmsProject.business.requests.educationTypeRequests.UpdateEducationTypeRequests;
import io.HrmsProject.business.responses.educationTypeResponses.GetAllEducationTypeResponses;
import io.HrmsProject.business.responses.educationTypeResponses.GetByEducationTypeIdResponses;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.EducationTypeDao;
import io.HrmsProject.entities.concretes.EducationType;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EducationTypeManager implements EducationTypeService{

	private EducationTypeDao educationTypeDao;
	private ModelMapperService modelMapperService;
	
	
	@Override
	public Result add(CreateEducationTypeRequests createEntity) throws Exception {
		
		EducationType educationType = this.modelMapperService.forRequest().map(createEntity, EducationType.class);
		this.educationTypeDao.save(educationType);
		
		return new SuccessResult("education type added.");
	}
	@Override
	public Result update(UpdateEducationTypeRequests updateEntity) {
		EducationType educationType = this.modelMapperService.forRequest().map(updateEntity, EducationType.class);
		this.educationTypeDao.save(educationType);
		
		return new SuccessResult("education type updated.");
	}
	@Override
	public Result delete(int id) {
		this.educationTypeDao.deleteById(id);
		return new SuccessResult("education type deleted");
	}
	
	@Override
	public DataResult<List<GetAllEducationTypeResponses>> getAll() {
		List<EducationType> educationTypes = educationTypeDao.findAll();
		
		List<GetAllEducationTypeResponses> educationTypesResponse = educationTypes.stream().map(educationType->this.modelMapperService.forResponse().map(educationType, GetAllEducationTypeResponses.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllEducationTypeResponses>>(educationTypesResponse);
	}
	
	@Override
	public DataResult<GetByEducationTypeIdResponses> getById(int id) {
		EducationType educationType = this.educationTypeDao.findById(id);
		
		GetByEducationTypeIdResponses response = this.modelMapperService.forResponse().map(educationType, GetByEducationTypeIdResponses.class);
		return new SuccessDataResult<GetByEducationTypeIdResponses>(response);
	}
	
	


}
