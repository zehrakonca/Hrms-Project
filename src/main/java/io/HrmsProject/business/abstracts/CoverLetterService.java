package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.coverLetterRequests.CreateCoverLetterRequests;
import io.HrmsProject.business.requests.coverLetterRequests.UpdateCoverLetterRequests;
import io.HrmsProject.business.responses.coverLetterResponses.GetAllCoverLetterResponses;
import io.HrmsProject.business.responses.coverLetterResponses.GetByIdCoverLetterResponses;
import io.HrmsProject.entities.concretes.CoverLetter;

public interface CoverLetterService extends BaseEntityService<CoverLetter, CreateCoverLetterRequests, UpdateCoverLetterRequests, GetAllCoverLetterResponses>{
	
	GetByIdCoverLetterResponses getById(int id);
}
