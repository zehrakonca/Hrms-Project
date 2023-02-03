package io.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.ProgramInfoService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.ErrorResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.ProgramInfoDao;
import io.HrmsProject.entities.concretes.ProgramInfo;

@Service
public class ProgramInfoManager implements ProgramInfoService {

	private ProgramInfoDao programInfoDao;
	private boolean isExist = false;
	
	@Autowired
	public ProgramInfoManager(ProgramInfoDao programInfoDao) {
		super();
		this.programInfoDao = programInfoDao;
	}

	@Override
	public Result add(ProgramInfo programInfo) {
		if(programInfo.getProgram() == null) {
			return new ErrorResult("program information cannot be blank.");
		}
		else if(isProgramExist(programInfo.getProgram())) {
			return new ErrorResult("this program name in list already.");
		}
		else {
			this.programInfoDao.save(programInfo);
		}
		return new SuccessResult("program information has been added.");
	}

	@Override
	public Result update(ProgramInfo programInfo, int id) {
		if(isProgramExist(programInfo.getProgram())) {
			return new ErrorResult("this program name in list already.");
		}
		else {
			programInfo.setProgram(programInfo.getProgram());
			this.programInfoDao.save(programInfo);
		}
		return new SuccessResult("program information has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.programInfoDao.deleteById(id);
		return new SuccessResult("program information has been deleted.");
	}

	@Override
	public DataResult<List<ProgramInfo>> getAll() {
		return new SuccessDataResult<List<ProgramInfo>>(this.programInfoDao.findAll(), "program information has been listed.");
	}

	@Override
	public DataResult<ProgramInfo> getById(int id) {
		return new SuccessDataResult<ProgramInfo>(this.programInfoDao.findById(id), "program information has been listed.");
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
}
