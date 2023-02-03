package io.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.EducationTypeService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.EducationTypeDao;
import io.HrmsProject.entities.concretes.EducationType;

@Service
public class EducationTypeManager implements EducationTypeService{

	private EducationTypeDao educationTypeDao;
	
	@Autowired
	public EducationTypeManager(EducationTypeDao educationTypeDao) {
		super();
		this.educationTypeDao = educationTypeDao;
	}

	@Override
	public Result add(EducationType educationType) {
		this.educationTypeDao.save(educationType);
		return new SuccessResult("education type has been added.");
	}

	@Override
	public Result update(EducationType educationType, int id) {
		this.educationTypeDao.findById(id);
		educationType.setEducationTypeName(educationType.getEducationTypeName());
		this.educationTypeDao.save(educationType);
		return new SuccessResult("education type has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.educationTypeDao.deleteById(id);
		return new SuccessResult("education type has been deleted.");
		
	}

	@Override
	public DataResult<List<EducationType>> getAll() {
		return new SuccessDataResult<List<EducationType>>(this.educationTypeDao.findAll(), "faculty information has been listed.");
	}

	@Override
	public DataResult<EducationType> getById(int id) {
		return new SuccessDataResult<EducationType>(this.educationTypeDao.findById(id), "faculty information has been listed.");
	}

}
