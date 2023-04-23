package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.ProgramInfoService;
import io.HrmsProject.business.requests.programRequests.CreateProgramRequest;
import io.HrmsProject.business.requests.programRequests.UpdateProgramRequest;
import io.HrmsProject.business.responses.programResponses.GetAllProgramResponse;
import io.HrmsProject.business.responses.programResponses.GetByIdProgramResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.ProgramInfoDao;
import io.HrmsProject.entities.concretes.ProgramInfo;

@Service
public class ProgramInfoManager implements ProgramInfoService {

	private ProgramInfoDao programInfoDao;
	private ModelMapperService modelMapperService;
	private boolean isExist = false;
	
	@Autowired
	public ProgramInfoManager(ProgramInfoDao programInfoDao,ModelMapperService modelMapperService) {
		super();
		this.programInfoDao = programInfoDao;
		this.modelMapperService =modelMapperService;
	}

	private boolean isProgramExist(String programName) {
		List<ProgramInfo> programInfos = programInfoDao.findAll();
		
		for(ProgramInfo programInfo : programInfos) {
			if(programInfo.getProgram().equalsIgnoreCase(programName)) {
				isExist = true;
			}
		}
		return isExist;
	}

	@Override
	public Result add(CreateProgramRequest createEntity) throws Exception {
		ProgramInfo programInfo = this.modelMapperService.forRequest().map(createEntity, ProgramInfo.class);
		this.programInfoDao.save(programInfo);
		return new SuccessResult("program info has been added.");
	}

	@Override
	public Result update(UpdateProgramRequest updateEntity) {
		ProgramInfo programInfo = this.modelMapperService.forRequest().map(updateEntity, ProgramInfo.class);
		this.programInfoDao.save(programInfo);
		return new SuccessResult("program info has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.programInfoDao.deleteById(id);
		return new SuccessResult("program info has been deleted.");
	}

	@Override
	public DataResult<List<GetAllProgramResponse>> getAll() {
		List<ProgramInfo> programInfos = programInfoDao.findAll();
		
		List<GetAllProgramResponse> programInfosResponse = programInfos.stream().map(programInfo->this.modelMapperService.forResponse().map(programInfo, GetAllProgramResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllProgramResponse>>(programInfosResponse);
	}

	@Override
	public DataResult<GetByIdProgramResponse> getById(int id) {
		ProgramInfo programInfo = this.programInfoDao.findById(id);
		
		GetByIdProgramResponse response = this.modelMapperService.forResponse().map(programInfo, GetByIdProgramResponse.class);
		
		return new SuccessDataResult<GetByIdProgramResponse>(response);
	}
}
