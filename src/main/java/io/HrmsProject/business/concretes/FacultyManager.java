package io.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.FacultyService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.ErrorResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.FacultyDao;
import io.HrmsProject.entities.concretes.Faculty;

@Service
public class FacultyManager implements FacultyService{

	private FacultyDao facultyDao;
	
	private boolean isExist= false;
	
	@Autowired
	public FacultyManager(FacultyDao facultyDao) {
		super();
		this.facultyDao = facultyDao;
	}

	@Override
	public Result add(Faculty faculty) {
		
		if((faculty.getFaculty() == null)) {
			return new ErrorResult("faculty name cannot be blank."); 
		}
		else if(isFacultyExist(faculty.getFaculty())) {
			return new ErrorResult("this faculty name already in list.");
		}
		else {
			this.facultyDao.save(faculty);
		}
		return new SuccessResult("faculty information has been added.");
 
	}

	@Override
	public Result update(Faculty faculty, int id) {
		this.facultyDao.findById(id);
		if(isFacultyExist(faculty.getFaculty())) {
			return new ErrorResult("job information already in list.");
		}
		else {
			faculty.setFaculty(faculty.getFaculty());
			this.facultyDao.save(faculty);
		}
		return new SuccessResult("faculty information has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.facultyDao.deleteById(id);
		return new SuccessResult("faculty information has been deleted.");
	}

	@Override
	public DataResult<List<Faculty>> getAll() {
		return new SuccessDataResult<List<Faculty>>(this.facultyDao.findAll(), "faculty information has been listed.");
	}

	@Override
	public DataResult<Faculty> getById(int id) {
		return new SuccessDataResult<Faculty>(this.facultyDao.findById(id), "faculty information has been listed.");
	}
	
	private boolean isFacultyExist(String facultyName){
		List<Faculty> faculties = facultyDao.findAll();
		
		for (Faculty faculty:faculties) {
			if(faculty.getFaculty().equalsIgnoreCase(facultyName)) {
				isExist = true;
			}
		}
		return isExist;
	}
}
