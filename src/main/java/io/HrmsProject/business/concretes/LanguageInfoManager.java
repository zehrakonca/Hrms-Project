package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.LanguageInfoService;
import io.HrmsProject.business.requests.languageInfoRequests.CreateLanguageInfoRequest;
import io.HrmsProject.business.requests.languageInfoRequests.UpdateLanguageInfoRequest;
import io.HrmsProject.business.responses.languageInfoResponses.GetAllLanguageInfoResponse;
import io.HrmsProject.business.responses.languageInfoResponses.GetByIdJobSeekerLanguageInfoResponse;
import io.HrmsProject.business.responses.languageInfoResponses.GetByIdLanguageInfoResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.JobSeekerDao;
import io.HrmsProject.dataAccess.abstracts.LanguageDao;
import io.HrmsProject.dataAccess.abstracts.LanguageInfoDao;
import io.HrmsProject.entities.concretes.JobSeeker;
import io.HrmsProject.entities.concretes.Language;
import io.HrmsProject.entities.concretes.LanguageInfo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageInfoManager implements LanguageInfoService{
	
	private LanguageDao languageDao;
	private JobSeekerDao jobSeekerDao;
	private LanguageInfoDao languageInfoDao;
	private ModelMapperService modelMapperService;
	
	@Override
	public Result add(CreateLanguageInfoRequest createEntity) throws Exception {
		LanguageInfo languageInfo = this.modelMapperService.forRequest().map(createEntity, LanguageInfo.class);
		JobSeeker jobSeeker = this.jobSeekerDao.findById(createEntity.getJobSeeker());
		Language language = this.languageDao.findById(createEntity.getLanguage());
		
		languageInfo.setJobSeeker(jobSeeker);
		languageInfo.setLanguage(language);
		this.languageInfoDao.save(languageInfo);
		return new SuccessResult("your language info has been added");
	}
	@Override
	public Result update(UpdateLanguageInfoRequest updateEntity) {
		LanguageInfo languageInfo = this.modelMapperService.forRequest().map(updateEntity, LanguageInfo.class);
		JobSeeker jobSeeker = this.jobSeekerDao.findById(updateEntity.getJobSeeker());
		Language language = this.languageDao.findById(updateEntity.getLanguage());
		
		languageInfo.setJobSeeker(jobSeeker);
		languageInfo.setLanguage(language);
		this.languageInfoDao.save(languageInfo);
		return new SuccessResult("your language info has been updated");
	}
	@Override
	public Result delete(int id) {
		this.languageInfoDao.deleteById(id);
		return new SuccessResult("your language info has been deleted");
	}
	@Override
	public DataResult<List<GetAllLanguageInfoResponse>> getAll() {
		List<LanguageInfo> languageInfos = languageInfoDao.findAll();
		
		List<GetAllLanguageInfoResponse> languageInfosResponse = languageInfos.stream().map(languageInfo->this.modelMapperService.forResponse().map(languageInfo, GetAllLanguageInfoResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllLanguageInfoResponse>>(languageInfosResponse);
	}
	@Override
	public GetByIdLanguageInfoResponse getById(int id) {
		
		LanguageInfo languageInfo = this.languageInfoDao.findById(id);
		
		GetByIdLanguageInfoResponse response = this.modelMapperService.forResponse().map(languageInfo, GetByIdLanguageInfoResponse.class);
		return response;
	}
	@Override
	public DataResult<List<GetByIdJobSeekerLanguageInfoResponse>> getByJobSeekerId(int jobSeekerId) {
		List<LanguageInfo> languageInfos = this.languageInfoDao.getByJobSeeker_Id(jobSeekerId);
		
		List<GetByIdJobSeekerLanguageInfoResponse> result = languageInfos.stream().map(languageInfo -> this.modelMapperService.forResponse().map(languageInfo, GetByIdJobSeekerLanguageInfoResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetByIdJobSeekerLanguageInfoResponse>>(result);
	}
	
}
