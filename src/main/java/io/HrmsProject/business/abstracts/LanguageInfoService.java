package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.business.requests.languageInfoRequests.CreateLanguageInfoRequest;
import io.HrmsProject.business.requests.languageInfoRequests.UpdateLanguageInfoRequest;
import io.HrmsProject.business.responses.languageInfoResponses.GetAllLanguageInfoResponse;
import io.HrmsProject.business.responses.languageInfoResponses.GetByIdJobSeekerLanguageInfoResponse;
import io.HrmsProject.business.responses.languageInfoResponses.GetByIdLanguageInfoResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.LanguageInfo;

public interface LanguageInfoService extends BaseEntityService<LanguageInfo, CreateLanguageInfoRequest, UpdateLanguageInfoRequest, GetAllLanguageInfoResponse>{
	
	GetByIdLanguageInfoResponse getById(int id);
	
	DataResult<List<GetByIdJobSeekerLanguageInfoResponse>> getByJobSeekerId(int jobSeekerId);
}
