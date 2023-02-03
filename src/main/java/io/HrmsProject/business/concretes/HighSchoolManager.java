package io.HrmsProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.HighSchoolService;
import io.HrmsProject.business.requests.highSchool.CreateHighSchoolInfoRequests;
import io.HrmsProject.business.requests.highSchool.UpdateHighSchoolInfoRequests;
import io.HrmsProject.business.responses.highSchoolResponses.GetAllHighSchoolResponses;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.HighSchoolDao;
import io.HrmsProject.dataAccess.abstracts.HighSchoolTypeDao;
import io.HrmsProject.dataAccess.abstracts.JobSeekerDao;
import io.HrmsProject.dataAccess.abstracts.ProgramInfoDao;
import io.HrmsProject.entities.concretes.HighSchool;
import io.HrmsProject.entities.concretes.HighSchoolType;
import io.HrmsProject.entities.concretes.JobSeeker;
import io.HrmsProject.entities.concretes.ProgramInfo;

@Service
public class HighSchoolManager implements HighSchoolService{

	private HighSchoolDao highSchoolDao;
	private HighSchoolTypeDao highSchoolTypeDao;
	private ProgramInfoDao programInfoDao;
	private JobSeekerDao jobSeeker;
	
	@Autowired
	public HighSchoolManager(HighSchoolDao highSchoolDao, HighSchoolTypeDao highSchoolTypeDao,
			ProgramInfoDao programInfoDao, JobSeekerDao jobSeeker) {
		super();
		this.highSchoolDao = highSchoolDao;
		this.highSchoolTypeDao = highSchoolTypeDao;
		this.programInfoDao = programInfoDao;
		this.jobSeeker = jobSeeker;
	}
	
	@Override
	public Result add(CreateHighSchoolInfoRequests createEntity) throws Exception {
		HighSchool highSchool = new HighSchool();
		HighSchoolType highSchoolType = this.highSchoolTypeDao.findById(createEntity.getHighSchoolType());
		ProgramInfo programInfo = this.programInfoDao.findById(createEntity.getProgram());
		JobSeeker jobSeeker = this.jobSeeker.findById(createEntity.getJobSeeker());
		
		highSchool.setHighSchoolName(createEntity.getHighSchoolName());
		highSchool.setStartedDate(createEntity.getStartedDate());
		highSchool.setGraduationDate(createEntity.getGraduationDate());
		
		highSchool.setHighSchoolType(highSchoolType);
		highSchool.setProgram(programInfo);
		highSchool.setJobSeeker(jobSeeker);
		
		this.highSchoolDao.save(highSchool);
		return new SuccessResult("your high school information has been saved.");
		
	}

	@Override
	public Result update(UpdateHighSchoolInfoRequests updateEntity, int id) {
		HighSchool highSchool = this.highSchoolDao.findById(id);
		
		HighSchoolType highSchoolType = this.highSchoolTypeDao.findById(updateEntity.getHighSchoolType());
		ProgramInfo programInfo = this.programInfoDao.findById(updateEntity.getProgram());
		JobSeeker jobSeeker = this.jobSeeker.findById(updateEntity.getJobSeeker());
		
		highSchool.setHighSchoolName(updateEntity.getHighSchoolName());
		highSchool.setStartedDate(updateEntity.getStartedDate());
		highSchool.setGraduationDate(updateEntity.getGraduationDate());
		
		this.highSchoolDao.save(highSchool);
		return new SuccessResult("your high school information has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.highSchoolDao.deleteById(id);
		return new SuccessResult("your high school information has been deleted.");
		
	}

	@Override
	public DataResult<List<GetAllHighSchoolResponses>> getAll() {
		List<HighSchool> highSchools = this.highSchoolDao.findAll();
		List<GetAllHighSchoolResponses> highSchoolResponses = new ArrayList<GetAllHighSchoolResponses>();
		
		for (HighSchool highSchool : highSchools) {
			GetAllHighSchoolResponses responseItem = new GetAllHighSchoolResponses();
			responseItem.setHighSchoolName(highSchool.getHighSchoolName());
			responseItem.setHighSchoolType(highSchool.getHighSchoolType().getHighSchoolType());
			responseItem.setProgram(highSchool.getProgram().getProgram());
			responseItem.setStartedDate(highSchool.getStartedDate());
			responseItem.setGraduationDate(highSchool.getGraduationDate());
			responseItem.setJobSeeker(highSchool.getJobSeeker().getEmail());
			
			highSchoolResponses.add(responseItem);
		}
		return new SuccessDataResult<List<GetAllHighSchoolResponses>>(highSchoolResponses);
 	}

	@Override
	public DataResult<HighSchool> getById(int id) {
		return new SuccessDataResult<HighSchool>(this.highSchoolDao.findById(id));
	}

}
