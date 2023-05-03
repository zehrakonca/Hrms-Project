package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.PositionLevelService;
import io.HrmsProject.business.requests.positionLevelRequests.CreatePositionLevelRequest;
import io.HrmsProject.business.requests.positionLevelRequests.UpdatePositionLevelRequest;
import io.HrmsProject.business.responses.positionLevelResponses.GetAllPositionLevelResponse;
import io.HrmsProject.business.responses.positionLevelResponses.GetByIdPositionLevelResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.PositionLevelDao;
import io.HrmsProject.entities.concretes.PositionLevel;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PositionLevelManager implements PositionLevelService {
	
	private PositionLevelDao positionLevelDao;
	private ModelMapperService modelMapperService;
	
	@Override
	public Result add(CreatePositionLevelRequest createEntity) throws Exception {
		PositionLevel positionLevel = this.modelMapperService.forRequest().map(createEntity, PositionLevel.class);
		this.positionLevelDao.save(positionLevel);
		return new SuccessResult("position level info has been added.");
	}
	@Override
	public Result update(UpdatePositionLevelRequest updateEntity) throws Exception {
		PositionLevel positionLevel = this.modelMapperService.forRequest().map(updateEntity, PositionLevel.class);
		this.positionLevelDao.save(positionLevel);
		return new SuccessResult("position level info has been updated.");
	}
	@Override
	public Result delete(int id) {
		this.positionLevelDao.deleteById(id);
		return new SuccessResult("position level info has been deleted.");
	}
	@Override
	public DataResult<List<GetAllPositionLevelResponse>> getAll() {
		List<PositionLevel> positionLevels = this.positionLevelDao.findAll();
		
		List<GetAllPositionLevelResponse> response = positionLevels.stream().map(positionLevel->this.modelMapperService.forResponse().map(positionLevel, GetAllPositionLevelResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllPositionLevelResponse>>(response);
				}
	@Override
	public DataResult<GetByIdPositionLevelResponse> getById(int id) {
		PositionLevel positionLevel = this.positionLevelDao.findById(id);
		
		GetByIdPositionLevelResponse response = this.modelMapperService.forResponse().map(positionLevel, GetByIdPositionLevelResponse.class);
		
		return new SuccessDataResult<GetByIdPositionLevelResponse>(response);
	}
	
	

}
