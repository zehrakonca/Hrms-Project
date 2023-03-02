package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.languageInfoRequests.CreateLanguageInfoRequest;
import io.HrmsProject.business.requests.languageInfoRequests.UpdateLanguageInfoRequest;
import io.HrmsProject.business.responses.languageInfoResponses.GetAllLanguageInfoResponse;
import io.HrmsProject.business.responses.languageInfoResponses.GetByIdLanguageInfoResponse;
import io.HrmsProject.entities.concretes.LanguageInfo;

public interface LanguageInfoService extends BaseEntityService<LanguageInfo, CreateLanguageInfoRequest, UpdateLanguageInfoRequest, GetAllLanguageInfoResponse>{
	
	GetByIdLanguageInfoResponse getById(int id);
}
