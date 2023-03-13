package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.UniversityService;
import io.HrmsProject.business.requests.universityRequests.CreateUniversityRequest;
import io.HrmsProject.business.requests.universityRequests.UpdateUniversityRequest;
import io.HrmsProject.business.responses.universityResponse.GetAllUniversityResponse;
import io.HrmsProject.business.responses.universityResponse.GetByIdUniversityResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.UniversityDao;
import io.HrmsProject.entities.concretes.University;

@Service
public class UniversityManager implements UniversityService{
	
	private UniversityDao universityDao;
	private ModelMapperService modelMapperService;
	
	private boolean isExist= false;

	@Autowired
	public UniversityManager(UniversityDao universityDao,ModelMapperService modelMapperService) {
		super();
		this.universityDao = universityDao;
		this.modelMapperService = modelMapperService;
	}
	
	private boolean isUniversityExist(String universityName){
		List<University> universities = universityDao.findAll();
		
		for (University university:universities) {
			if(university.getUniversity().equalsIgnoreCase(universityName)) {
				isExist = true;
			}
		}
		return isExist;
	}

	@Override
	public Result add(CreateUniversityRequest createEntity) throws Exception {
		University university = this.modelMapperService.forRequest().map(createEntity, University.class);
		this.universityDao.save(university);
		return new SuccessResult("university info has been saved.");
	}

	@Override
	public Result update(UpdateUniversityRequest updateEntity) {
		University university = this.modelMapperService.forRequest().map(updateEntity, University.class);
		this.universityDao.save(university);
		return new SuccessResult("university info has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.universityDao.deleteById(id);
		return new SuccessResult("university info has been deleted.");
	}

	@Override
	public DataResult<List<GetAllUniversityResponse>> getAll() {
		List<University> universities = universityDao.findAll();
		
		List<GetAllUniversityResponse> universitiesResponse = universities.stream().map(university->this.modelMapperService.forResponse().map(university, GetAllUniversityResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllUniversityResponse>>(universitiesResponse);
	}

	@Override
	public DataResult<GetByIdUniversityResponse> getById(int id) {
		University university = this.universityDao.findById(id);
		
		GetByIdUniversityResponse response = this.modelMapperService.forResponse().map(university, GetByIdUniversityResponse.class);
		return new SuccessDataResult<GetByIdUniversityResponse>(response);
	}

}
