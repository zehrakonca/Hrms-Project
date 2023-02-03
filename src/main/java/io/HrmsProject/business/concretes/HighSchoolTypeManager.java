package io.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.HighSchoolTypeService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.HighSchoolTypeDao;
import io.HrmsProject.entities.concretes.HighSchoolType;

@Service
public class HighSchoolTypeManager implements HighSchoolTypeService{

	private HighSchoolTypeDao highSchoolTypeDao;
	
	@Autowired
	public HighSchoolTypeManager(HighSchoolTypeDao highSchoolTypeDao) {
		super();
		this.highSchoolTypeDao = highSchoolTypeDao;
	}

	@Override
	public Result add(HighSchoolType highSchoolType) {
		this.highSchoolTypeDao.save(highSchoolType);
		return new SuccessResult("high school information has been added.");
	}

	@Override
	public Result delete(int id) {
		this.highSchoolTypeDao.deleteById(id);
		return new SuccessResult("high school information has been deleted.");
	}

	@Override
	public DataResult<List<HighSchoolType>> getAll() {
		return new SuccessDataResult<List<HighSchoolType>>(this.highSchoolTypeDao.findAll(), "high school information has been listed.");
	}

	@Override
	public DataResult<HighSchoolType> getById(int id) {
		return new SuccessDataResult<HighSchoolType>(this.highSchoolTypeDao.findById(id));
	}

}
