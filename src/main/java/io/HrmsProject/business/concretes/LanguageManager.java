package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.LanguageService;
import io.HrmsProject.business.requests.languageRequests.CreateLanguageRequest;
import io.HrmsProject.business.requests.languageRequests.UpdateLanguageRequest;
import io.HrmsProject.business.responses.languageResponse.GetAllLanguageResponse;
import io.HrmsProject.business.responses.languageResponse.GetByIdLanguageResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.LanguageDao;
import io.HrmsProject.entities.concretes.Language;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService{
	
	private LanguageDao languageDao;
	private ModelMapperService modelMapperService;
	
	
	@Override
	public Result add(CreateLanguageRequest createEntity) throws Exception {
		Language language = this.modelMapperService.forRequest().map(createEntity, Language.class);
		this.languageDao.save(language);
		return new SuccessResult("language info has been added.");
	}
	@Override
	public Result update(UpdateLanguageRequest updateEntity) {
		Language language = this.modelMapperService.forRequest().map(updateEntity, Language.class);
		this.languageDao.save(language);
		return new SuccessResult("language info has been updated.");
	}
	@Override
	public Result delete(int id) {
		this.languageDao.deleteById(id);
		return new SuccessResult("language info has been deleted.");
	}
	@Override
	public DataResult<List<GetAllLanguageResponse>> getAll() {
		List<Language> languages = languageDao.findAll();
		
		List<GetAllLanguageResponse> languagesResponse = languages.stream().map(language->this.modelMapperService.forResponse().map(language, GetAllLanguageResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllLanguageResponse>>(languagesResponse);
	}
	@Override
	public GetByIdLanguageResponse getById(int id) {
		Language language = this.languageDao.findById(id);
		
		GetByIdLanguageResponse response = this.modelMapperService.forResponse().map(language, GetByIdLanguageResponse.class);
		return response;
	}
	
	
}
