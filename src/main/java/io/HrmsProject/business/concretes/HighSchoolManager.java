package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.HighSchoolService;
import io.HrmsProject.business.requests.highSchoolRequests.CreateHighSchoolInfoRequests;
import io.HrmsProject.business.requests.highSchoolRequests.UpdateHighSchoolInfoRequests;
import io.HrmsProject.business.responses.highSchoolResponses.GetAllHighSchoolResponses;
import io.HrmsProject.business.responses.highSchoolResponses.GetByIdHighSchoolResponse;
import io.HrmsProject.business.responses.highSchoolResponses.GetByJobSeekerIdResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
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
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HighSchoolManager implements HighSchoolService{

	private HighSchoolDao highSchoolDao;
	private HighSchoolTypeDao highSchoolTypeDao;
	private ProgramInfoDao programInfoDao;
	private JobSeekerDao jobSeeker;
	private ModelMapperService modelMapperService;
	
	@Override
	public Result add(CreateHighSchoolInfoRequests createEntity) throws Exception {
		HighSchool highSchool = this.modelMapperService.forRequest().map(createEntity, HighSchool.class);
		HighSchoolType highSchoolType = this.highSchoolTypeDao.findById(createEntity.getHighSchoolType());
		ProgramInfo programInfo = this.programInfoDao.findById(createEntity.getProgram());
		JobSeeker jobSeeker = this.jobSeeker.findById(createEntity.getJobSeeker());
		
		highSchool.setHighSchoolType(highSchoolType);
		highSchool.setProgram(programInfo);
		highSchool.setJobSeeker(jobSeeker);
		
		this.highSchoolDao.save(highSchool);
		return new SuccessResult("your high school information has been saved.");
		
	}

	@Override
	public Result update(UpdateHighSchoolInfoRequests updateEntity) {
		HighSchool highSchool = this.modelMapperService.forRequest().map(updateEntity, HighSchool.class);
		
		HighSchoolType highSchoolType = this.highSchoolTypeDao.findById(updateEntity.getHighSchoolType());
		ProgramInfo programInfo = this.programInfoDao.findById(updateEntity.getProgram());
		JobSeeker jobSeeker = this.jobSeeker.findById(updateEntity.getJobSeeker());
		
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
		List<GetAllHighSchoolResponses> highSchoolResponses = highSchools.stream().map(highSchool->this.modelMapperService.forResponse().map(highSchool, GetAllHighSchoolResponses.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllHighSchoolResponses>>(highSchoolResponses);
 	}

	@Override
	public DataResult<GetByIdHighSchoolResponse> getById(int id) {
		HighSchool highSchool = this.highSchoolDao.findById(id);
		
		GetByIdHighSchoolResponse response = this.modelMapperService.forResponse().map(highSchool, GetByIdHighSchoolResponse.class);
		return new SuccessDataResult<GetByIdHighSchoolResponse>(response);
	}

	@Override
	public DataResult<GetByJobSeekerIdResponse> getByJobSeekerId(int jobSeekerId) {
		HighSchool highSchool = this.highSchoolDao.findByJobSeeker_Id(jobSeekerId);
		
		GetByJobSeekerIdResponse response = this.modelMapperService.forResponse().map(highSchool, GetByJobSeekerIdResponse.class);
		return new SuccessDataResult<GetByJobSeekerIdResponse>(response);
	}

}
