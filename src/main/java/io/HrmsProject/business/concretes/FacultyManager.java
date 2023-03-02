package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.FacultyService;
import io.HrmsProject.business.requests.facultyRequests.CreateFacultyRequests;
import io.HrmsProject.business.requests.facultyRequests.UpdateFacultyRequests;
import io.HrmsProject.business.responses.facultyResponses.GetAllFacultyResponse;
import io.HrmsProject.business.responses.facultyResponses.GetByIdFacultyResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.FacultyDao;
import io.HrmsProject.entities.concretes.Faculty;

@Service
public class FacultyManager implements FacultyService{

	private FacultyDao facultyDao;
	private ModelMapperService modelMapperService;
	
	private boolean isExist= false;
	
	@Autowired
	public FacultyManager(FacultyDao facultyDao,ModelMapperService modelMapperService) {
		super();
		this.facultyDao = facultyDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateFacultyRequests createEntity) throws Exception {
		Faculty faculty = this.modelMapperService.forRequest().map(createEntity, Faculty.class);
		this.facultyDao.save(faculty);
		
		return new SuccessResult("faculty has been added.");
	}

	@Override
	public Result update(UpdateFacultyRequests updateEntity) {
		Faculty faculty = this.modelMapperService.forRequest().map(updateEntity, Faculty.class);
		this.facultyDao.save(faculty);
		
		return new SuccessResult("faculty has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.facultyDao.deleteById(id);
		return new SuccessResult("faculty has been deleted.");
	}

	@Override
	public DataResult<List<GetAllFacultyResponse>> getAll() {
		List<Faculty> faculties = facultyDao.findAll();
		
		List<GetAllFacultyResponse> facultiesResponse = faculties.stream().map(faculty->this.modelMapperService.forResponse().map(faculty, GetAllFacultyResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllFacultyResponse>>(facultiesResponse);
	}

	@Override
	public GetByIdFacultyResponse getById(int id) {
		Faculty faculty = this.facultyDao.findById(id);
		
		GetByIdFacultyResponse response = this.modelMapperService.forResponse().map(faculty, GetByIdFacultyResponse.class);
		return response;
	}

	
}
