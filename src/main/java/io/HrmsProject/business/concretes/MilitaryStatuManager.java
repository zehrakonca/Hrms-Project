package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.MilitaryStatuService;
import io.HrmsProject.business.requests.militaryStatuRequests.CreateMilitaryStatuRequest;
import io.HrmsProject.business.requests.militaryStatuRequests.UpdateMilitaryStatuRequest;
import io.HrmsProject.business.responses.militaryStatuResponses.GetAllMilitaryStatuResponse;
import io.HrmsProject.business.responses.militaryStatuResponses.GetByIdMilitaryStatuResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.MilitaryStatuDao;
import io.HrmsProject.entities.concretes.MilitaryStatu;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MilitaryStatuManager implements MilitaryStatuService{
	
	private MilitaryStatuDao militaryStatuDao;
	private ModelMapperService modelMapperService;
	@Override
	public Result add(CreateMilitaryStatuRequest createEntity) throws Exception {
		MilitaryStatu militaryStatu = this.modelMapperService.forRequest().map(createEntity, MilitaryStatu.class);
		this.militaryStatuDao.save(militaryStatu);
		return new SuccessResult("military statu info added.");
	}
	@Override
	public Result update(UpdateMilitaryStatuRequest updateEntity) throws Exception {
		MilitaryStatu militaryStatu = this.modelMapperService.forRequest().map(updateEntity, MilitaryStatu.class);
		this.militaryStatuDao.save(militaryStatu);
		return new SuccessResult("military statu info has been updated.");
	}
	@Override
	public Result delete(int id) {
		this.militaryStatuDao.deleteById(id);
		return new SuccessResult("military statu has been deleted.");
	}
	@Override
	public DataResult<List<GetAllMilitaryStatuResponse>> getAll() {
		List<MilitaryStatu> militaryStatus = this.militaryStatuDao.findAll();
		
		List<GetAllMilitaryStatuResponse> response = militaryStatus.stream().map(militaryStatu->this.modelMapperService.forResponse().map(militaryStatu, GetAllMilitaryStatuResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllMilitaryStatuResponse>>(response);
	}
	@Override
	public DataResult<GetByIdMilitaryStatuResponse> getById(int id) {
		MilitaryStatu militaryStatu = this.militaryStatuDao.findById(id);
		
		GetByIdMilitaryStatuResponse response = this.modelMapperService.forResponse().map(militaryStatu, GetByIdMilitaryStatuResponse.class);
		return new SuccessDataResult<GetByIdMilitaryStatuResponse>(response);
	}
	
	

}
