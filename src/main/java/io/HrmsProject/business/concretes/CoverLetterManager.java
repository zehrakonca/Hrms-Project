package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.CoverLetterService;
import io.HrmsProject.business.requests.coverLetterRequests.CreateCoverLetterRequests;
import io.HrmsProject.business.requests.coverLetterRequests.UpdateCoverLetterRequests;
import io.HrmsProject.business.responses.coverLetterResponses.GetAllCoverLetterResponses;
import io.HrmsProject.business.responses.coverLetterResponses.GetByIdCoverLetterResponses;
import io.HrmsProject.business.responses.coverLetterResponses.GetByIdJobSeekerCoverLetterResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.CoverLetterDao;
import io.HrmsProject.dataAccess.abstracts.JobSeekerDao;
import io.HrmsProject.entities.concretes.CoverLetter;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CoverLetterManager implements CoverLetterService{
	
	private CoverLetterDao coverLetterDao;
	private JobSeekerDao jobSeekerDao;
	private ModelMapperService modelMapperService;
	
	@Override
	public Result add(CreateCoverLetterRequests createEntity) throws Exception {
		CoverLetter coverLetter = this.modelMapperService.forRequest().map(createEntity, CoverLetter.class);
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("your coverletter has been saved.");
	}

	@Override
	public Result update(UpdateCoverLetterRequests updateEntity) {
		CoverLetter coverLetter = this.modelMapperService.forRequest().map(updateEntity, CoverLetter.class);
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("your coverletter has been saved.");
	}

	@Override
	public Result delete(int id) {
		this.coverLetterDao.deleteById(id);
		return new SuccessResult("your coverletter has been deleted.");
	}

	@Override
	public DataResult<List<GetAllCoverLetterResponses>> getAll() {
		List<CoverLetter> coverLetters = this.coverLetterDao.findAll();
		
		List<GetAllCoverLetterResponses> coverLetterResponse = coverLetters.stream().map(coverLetter->this.modelMapperService.forResponse().map(coverLetter, GetAllCoverLetterResponses.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllCoverLetterResponses>>(coverLetterResponse);
	}

	@Override
	public DataResult<GetByIdCoverLetterResponses> getById(int id) {
		CoverLetter coverLetter = this.coverLetterDao.findById(id);
		
		GetByIdCoverLetterResponses response = this.modelMapperService.forResponse().map(coverLetter, GetByIdCoverLetterResponses.class);
		
		return new SuccessDataResult<GetByIdCoverLetterResponses>(response);
	}

	@Override
	public DataResult<List<GetByIdJobSeekerCoverLetterResponse>> getByJobSeeker(int jobSeeker) {
		List<CoverLetter> coverLetters = this.coverLetterDao.findByJobSeeker_Id(jobSeeker);
		
		List<GetByIdJobSeekerCoverLetterResponse> coverLetterResponse = coverLetters.stream().map(coverLetter->this.modelMapperService.forResponse().map(coverLetter, GetByIdJobSeekerCoverLetterResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetByIdJobSeekerCoverLetterResponse>>(coverLetterResponse);
	}

}
