package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.HighSchoolTypeService;
import io.HrmsProject.business.requests.highSchoolTypeRequests.CreateHighSchoolTypeRequest;
import io.HrmsProject.business.requests.highSchoolTypeRequests.UpdateHighSchoolTypeRequest;
import io.HrmsProject.business.responses.highSchoolTypeResponses.GetAllHighSchoolTypeResponse;
import io.HrmsProject.business.responses.highSchoolTypeResponses.GetByIdHighSchoolTypeResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.HighSchoolTypeDao;
import io.HrmsProject.entities.concretes.HighSchoolType;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HighSchoolTypeManager implements HighSchoolTypeService{

	private HighSchoolTypeDao highSchoolTypeDao;
	private ModelMapperService modelMapperService;
	
	@Override
	public Result add(CreateHighSchoolTypeRequest createEntity) throws Exception {
		HighSchoolType highSchoolType = this.modelMapperService.forRequest().map(createEntity, HighSchoolType.class);
		this.highSchoolTypeDao.save(highSchoolType);
		return new SuccessResult("highschool type has been added.");
	}
	@Override
	public Result update(UpdateHighSchoolTypeRequest updateEntity) {
		HighSchoolType highSchoolType = this.modelMapperService.forRequest().map(updateEntity, HighSchoolType.class);
		this.highSchoolTypeDao.save(highSchoolType);
		return new SuccessResult("highschool type has been updated.");
	}
	@Override
	public Result delete(int id) {
		this.highSchoolTypeDao.deleteById(id);
		return new SuccessResult("highschool type has been deleted.");
	}
	@Override
	public DataResult<List<GetAllHighSchoolTypeResponse>> getAll() {
		List<HighSchoolType> highSchoolTypes = highSchoolTypeDao.findAll();
		
		List<GetAllHighSchoolTypeResponse> highSchoolTypesResponse = highSchoolTypes.stream().map(highSchoolType->this.modelMapperService.forResponse().map(highSchoolType, GetAllHighSchoolTypeResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllHighSchoolTypeResponse>>(highSchoolTypesResponse);
		
	}
	@Override
	public DataResult<GetByIdHighSchoolTypeResponse> getById(int id) {
		HighSchoolType highSchoolType = this.highSchoolTypeDao.findById(id);
		
		GetByIdHighSchoolTypeResponse response = this.modelMapperService.forResponse().map(highSchoolType, GetByIdHighSchoolTypeResponse.class);
		return new SuccessDataResult<GetByIdHighSchoolTypeResponse>(response);
	}
	
	
}
