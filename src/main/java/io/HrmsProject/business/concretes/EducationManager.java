package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.EducationService;
import io.HrmsProject.business.requests.educationRequests.CreateEducationRequests;
import io.HrmsProject.business.requests.educationRequests.UpdateEducationRequests;
import io.HrmsProject.business.responses.educationResponses.GetAllEducationResponses;
import io.HrmsProject.business.responses.educationResponses.GetByIdEducationResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.EducationDao;
import io.HrmsProject.dataAccess.abstracts.EducationTypeDao;
import io.HrmsProject.dataAccess.abstracts.FacultyDao;
import io.HrmsProject.dataAccess.abstracts.JobSeekerDao;
import io.HrmsProject.dataAccess.abstracts.ProgramInfoDao;
import io.HrmsProject.dataAccess.abstracts.UniversityDao;
import io.HrmsProject.entities.concretes.Education;
import io.HrmsProject.entities.concretes.EducationType;
import io.HrmsProject.entities.concretes.Faculty;
import io.HrmsProject.entities.concretes.JobSeeker;
import io.HrmsProject.entities.concretes.ProgramInfo;
import io.HrmsProject.entities.concretes.University;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EducationManager implements EducationService{
	
	private EducationDao educationDao;
	private UniversityDao universityDao;
	private FacultyDao facultyDao; 
	private EducationTypeDao educationTypeDao;
	private ProgramInfoDao programInfoDao;
	private JobSeekerDao jobSeekerDao;
	private ModelMapperService modelMapperService;

	@Override
	public Result add(CreateEducationRequests createEntity) throws Exception {
		Education education = this.modelMapperService.forRequest().map(createEntity, Education.class);
		
		EducationType educationType = this.educationTypeDao.findById(createEntity.getEducationType());
		ProgramInfo programInfo = this.programInfoDao.findById(createEntity.getProgram());
		JobSeeker jobSeeker = this.jobSeekerDao.findById(createEntity.getJobSeeker());
		University university = this.universityDao.findById(createEntity.getEducationType());
		Faculty faculty = this.facultyDao.findById(createEntity.getFaculty());
		
		education.setEducationType(educationType);
		education.setFaculty(faculty);
		education.setUniversity(university);
		education.setEducationType(educationType);
		education.setProgram(programInfo);
		education.setJobSeeker(jobSeeker);
		
		
		this.educationDao.save(education);
		return new SuccessResult("your education information has been saved.");
	}

	@Override
	public Result update(UpdateEducationRequests updateEntity) {
		Education education =this.modelMapperService.forRequest().map(updateEntity, Education.class);
		EducationType educationType = this.educationTypeDao.findById(updateEntity.getEducationType());
		ProgramInfo programInfo = this.programInfoDao.findById(updateEntity.getProgram());
		JobSeeker jobSeeker = this.jobSeekerDao.findById(updateEntity.getJobSeeker());
		University university = this.universityDao.findById(updateEntity.getEducationType());
		Faculty faculty = this.facultyDao.findById(updateEntity.getFaculty());
		
		education.setEducationType(educationType);
		education.setFaculty(faculty);
		education.setUniversity(university);
		education.setEducationType(educationType);
		education.setProgram(programInfo);
		education.setJobSeeker(jobSeeker);
		
		this.educationDao.save(education);
		return new SuccessResult("your education information has been saved.");
	}

	@Override
	public Result delete(int id) {
		this.educationDao.deleteById(id);
		return new SuccessResult("your education information has been deleted.");
	}

	@Override
	public DataResult<List<GetAllEducationResponses>> getAll() {
		List<Education> educations = this.educationDao.findAll();
		List<GetAllEducationResponses> educationResponses = educations.stream().map(education->this.modelMapperService.forResponse().map(education, GetAllEducationResponses.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllEducationResponses>>(educationResponses);
	}

	@Override
	public GetByIdEducationResponse getById(int id) {
		Education education = this.educationDao.findById(id);
		GetByIdEducationResponse response = this.modelMapperService.forResponse().map(education, GetByIdEducationResponse.class);
		
		return response;
	}

	@Override
	public DataResult<List<Education>> getAllBySortedGraduationDate(int jobSeekerId) {
		Sort sort = Sort.by(Sort.Direction.DESC,"graduationDate");
		
		return new SuccessDataResult<List<Education>>(educationDao.getByJobSeeker_Id(jobSeekerId,sort));
	}

}
