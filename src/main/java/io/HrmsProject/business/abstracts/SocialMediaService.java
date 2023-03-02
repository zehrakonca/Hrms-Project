package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.socialMediaRequests.CreateSocialMediaRequest;
import io.HrmsProject.business.requests.socialMediaRequests.UpdateSocialMediaRequest;
import io.HrmsProject.business.responses.socialMediaResponses.GetAllSocialMediaResponse;
import io.HrmsProject.business.responses.socialMediaResponses.GetByIdJobSeekerSocialMediaResponse;
import io.HrmsProject.business.responses.socialMediaResponses.GetByIdSocialMediaResponse;
import io.HrmsProject.entities.concretes.SocialMedia;

public interface SocialMediaService extends BaseEntityService<SocialMedia, CreateSocialMediaRequest, UpdateSocialMediaRequest, GetAllSocialMediaResponse>{
	
	GetByIdJobSeekerSocialMediaResponse getByJobSeekerId(int jobSeekerId);
	
	GetByIdSocialMediaResponse getById(int id);

}
