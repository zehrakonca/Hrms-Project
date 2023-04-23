package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.TypeOfWorkService;
import io.HrmsProject.business.requests.typeOfWorkRequests.CreateTypeOfWorkRequest;
import io.HrmsProject.business.requests.typeOfWorkRequests.UpdateTypeOfWorkRequest;
import io.HrmsProject.business.responses.typeOfworkResponses.GetAllTypeOfWorkResponse;
import io.HrmsProject.business.responses.typeOfworkResponses.GetByIdTypeOfWorkResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.TypeOfWorkDao;
import io.HrmsProject.entities.concretes.TypeOfWork;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TypeOfWorkManager implements TypeOfWorkService{
	
	private TypeOfWorkDao typeOfWorkDao;
	private ModelMapperService modelMapperService;
	
	@Override
	public Result add(CreateTypeOfWorkRequest createEntity) throws Exception {
		
		TypeOfWork typeOfWork = this.modelMapperService.forRequest().map(createEntity, TypeOfWork.class);
		this.typeOfWorkDao.save(typeOfWork);
		return new SuccessResult("type of work has been added.");
	}

	@Override
	public Result update(UpdateTypeOfWorkRequest updateEntity) throws Exception {
		
		TypeOfWork typeOfWork = this.modelMapperService.forRequest().map(updateEntity, TypeOfWork.class);
		this.typeOfWorkDao.save(typeOfWork);
		return new SuccessResult("type of work has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.typeOfWorkDao.deleteById(id);
		return new SuccessResult("type of work deleted.");
	}

	@Override
	public DataResult<List<GetAllTypeOfWorkResponse>> getAll() {
		List<TypeOfWork> typeOfWorks = this.typeOfWorkDao.findAll();
		
		List<GetAllTypeOfWorkResponse> typeOfWorkResponse = typeOfWorks.stream().map(typeOfWork->this.modelMapperService.forResponse().map(typeOfWork, GetAllTypeOfWorkResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllTypeOfWorkResponse>>(typeOfWorkResponse);
 	}

	@Override
	public DataResult<GetByIdTypeOfWorkResponse> getById(int id) {
		TypeOfWork typeOfWork = this.typeOfWorkDao.findById(id);
		
		GetByIdTypeOfWorkResponse response = this.modelMapperService.forResponse().map(typeOfWork, GetByIdTypeOfWorkResponse.class);
		
		return new SuccessDataResult<GetByIdTypeOfWorkResponse>(response);
	}

}
