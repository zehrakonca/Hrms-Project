package io.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.UniversityService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.ErrorResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.UniversityDao;
import io.HrmsProject.entities.concretes.University;

@Service
public class UniversityManager implements UniversityService{
	
	public UniversityDao universityDao;
	
	private boolean isExist= false;

	@Autowired
	public UniversityManager(UniversityDao universityDao) {
		super();
		this.universityDao = universityDao;
	}

	@Override
	public Result add(University university) {
		if (university.getUniversityName() == null) {
			return new ErrorResult("university name cannot be blank."); 
		}
		else if(isUniversityExist(university.getUniversityName())) {
			return new ErrorResult("this faculty name already in list.");
		}
		else {
			this.universityDao.save(university);
		}
		return new SuccessResult("university has been added.");
	}

	@Override
	public Result update(University university, int id) {
		this.universityDao.findById(id);
		
		if(isUniversityExist(university.getUniversityName())) {
			return new ErrorResult("university information already in list.");
		}
		else {
			university.setUniversityName(university.getUniversityName());
			this.universityDao.save(university);
		}
		return new SuccessResult("university information has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.universityDao.deleteById(id);
		return new SuccessResult("faculty information has been deleted.");
	}

	@Override
	public DataResult<List<University>> getAll() {
		return new SuccessDataResult<List<University>>(this.universityDao.findAll(), "faculty information has been listed.");
	}

	@Override
	public DataResult<University> getById(int id) {
		return new SuccessDataResult<University>(this.universityDao.findById(id));
	}
	
	private boolean isUniversityExist(String universityName){
		List<University> universities = universityDao.findAll();
		
		for (University university:universities) {
			if(university.getUniversityName().equalsIgnoreCase(universityName)) {
				isExist = true;
			}
		}
		return isExist;
	}

}
