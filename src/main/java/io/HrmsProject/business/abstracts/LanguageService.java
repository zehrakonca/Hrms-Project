package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.languageRequests.CreateLanguageRequest;
import io.HrmsProject.business.requests.languageRequests.UpdateLanguageRequest;
import io.HrmsProject.business.responses.languageResponse.GetAllLanguageResponse;
import io.HrmsProject.business.responses.languageResponse.GetByIdLanguageResponse;
import io.HrmsProject.entities.concretes.Language;

public interface LanguageService extends BaseEntityService<Language, CreateLanguageRequest, UpdateLanguageRequest, GetAllLanguageResponse,GetByIdLanguageResponse>{
}
