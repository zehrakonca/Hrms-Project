package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.business.requests.jobAdvertisementRequests.CreateJobAdvertisementRequests;
import io.HrmsProject.business.requests.jobAdvertisementRequests.UpdateJobAdvertisementRequests;
import io.HrmsProject.business.responses.jobAdvertisementResponses.GetAllJobAdvertisementResponses;
import io.HrmsProject.business.responses.jobAdvertisementResponses.GetByIdJobAdvertisementResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService extends BaseEntityService<JobAdvertisement, CreateJobAdvertisementRequests, UpdateJobAdvertisementRequests, GetAllJobAdvertisementResponses,GetByIdJobAdvertisementResponse>{
	
	Result makeActiveOrPassive(boolean isActive, int id);

	Result update(JobAdvertisement jobAdvertisement, int id);
	
	DataResult<List<GetAllJobAdvertisementResponses>> getAllByIsActive(boolean isActive);
	
	DataResult<List<GetAllJobAdvertisementResponses>> getJobAdvertisementDetailSorted();
	
	DataResult<List<GetAllJobAdvertisementResponses>> getByIsActiveAndEmployerId(boolean isActive,int employerId);
	
	DataResult<List<GetAllJobAdvertisementResponses>> getByCompanyName(String companyName,boolean isActive);
	
	DataResult<List<GetAllJobAdvertisementResponses>> getAllByJobAdvertisementName(String advertisementName);
	
	DataResult<List<GetAllJobAdvertisementResponses>> getBySectorAndCity(int sectorId, int cityId);
}
