package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.business.requests.jobAdvertisementRequests.CreateJobAdvertisementRequests;
import io.HrmsProject.business.requests.jobAdvertisementRequests.UpdateJobAdvertisementRequests;
import io.HrmsProject.business.responses.jobAdvertisementResponses.GetAllJobAdvertisementResponses;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService extends BaseEntityService<JobAdvertisement, CreateJobAdvertisementRequests, UpdateJobAdvertisementRequests, GetAllJobAdvertisementResponses>{
	
	Result makeActiveOrPassive(boolean isActive, int id);

	Result update(JobAdvertisement jobAdvertisement, int id);
	
	DataResult<List<JobAdvertisement>> getAllByIsActive(boolean isActive);
	
	DataResult<List<JobAdvertisement>> getJobAdvertisementDetailSorted();
	
	DataResult<List<JobAdvertisement>> getByIsActiveAndEmployerId(int employerId);
	
	DataResult<List<JobAdvertisement>> getByCompanyName(String companyName);
	
}
