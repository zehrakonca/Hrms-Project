package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.SocialMediaService;
import io.HrmsProject.business.requests.socialMediaRequests.CreateSocialMediaRequest;
import io.HrmsProject.business.requests.socialMediaRequests.UpdateSocialMediaRequest;
import io.HrmsProject.business.responses.socialMediaResponses.GetAllSocialMediaResponse;
import io.HrmsProject.business.responses.socialMediaResponses.GetByIdJobSeekerSocialMediaResponse;
import io.HrmsProject.business.responses.socialMediaResponses.GetByIdSocialMediaResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.JobSeekerDao;
import io.HrmsProject.dataAccess.abstracts.SocialMediaDao;
import io.HrmsProject.entities.concretes.JobSeeker;
import io.HrmsProject.entities.concretes.SocialMedia;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SocialMediaManager implements SocialMediaService {
	
	private JobSeekerDao jobSeekerDao;
	private SocialMediaDao socialMediaDao;
	private ModelMapperService modelMapperService;
	
	@Override
	public Result add(CreateSocialMediaRequest createEntity) throws Exception {
		SocialMedia socialMedia = this.modelMapperService.forRequest().map(createEntity, SocialMedia.class);
		JobSeeker jobSeeker = this.jobSeekerDao.findById(createEntity.getJobSeekerId());
		socialMedia.setJobSeeker(jobSeeker);
		this.socialMediaDao.save(socialMedia);
		return new SuccessResult("social media information has been added.");
	}
	@Override
	public Result update(UpdateSocialMediaRequest updateEntity) {
		SocialMedia socialMedia = this.modelMapperService.forRequest().map(updateEntity, SocialMedia.class);
		JobSeeker jobSeeker = this.jobSeekerDao.findById(updateEntity.getJobSeekerId());
		socialMedia.setJobSeeker(jobSeeker);
		this.socialMediaDao.save(socialMedia);
		return new SuccessResult("social media information has been updated.");
	}
	@Override
	public Result delete(int id) {
		this.socialMediaDao.deleteById(id);
		return new SuccessResult("social media information has been deleted.");
	}
	@Override
	public DataResult<List<GetAllSocialMediaResponse>> getAll() {
		List<SocialMedia> socialMedias = socialMediaDao.findAll();
		
		List<GetAllSocialMediaResponse> socialMediasResponse = socialMedias.stream().map(socialMedia->this.modelMapperService.forResponse().map(socialMedia, GetAllSocialMediaResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllSocialMediaResponse>>(socialMediasResponse);
	}
	@Override
	public DataResult<GetByIdSocialMediaResponse> getById(int id) {
		SocialMedia socialMedia = this.socialMediaDao.findById(id);
		GetByIdSocialMediaResponse response = this.modelMapperService.forResponse().map(socialMedia, GetByIdSocialMediaResponse.class);
		return new SuccessDataResult<GetByIdSocialMediaResponse>(response);
	}
	@Override
	public GetByIdJobSeekerSocialMediaResponse getByJobSeekerId(int jobSeekerId) {
		SocialMedia socialMedia = this.socialMediaDao.findByJobSeeker_Id(jobSeekerId);
		GetByIdJobSeekerSocialMediaResponse response = this.modelMapperService.forResponse().map(socialMedia, GetByIdJobSeekerSocialMediaResponse.class);
		return response;
	}
	
}
