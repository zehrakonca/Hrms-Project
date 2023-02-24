package io.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.SocialMediaService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.JobSeekerDao;
import io.HrmsProject.dataAccess.abstracts.SocialMediaDao;
import io.HrmsProject.entities.concretes.JobSeeker;
import io.HrmsProject.entities.concretes.SocialMedia;

@Service
public class SocialMediaManager implements SocialMediaService {
	
	private JobSeekerDao jobSeekerDao;
	private SocialMediaDao socialMediaDao;
	
	@Autowired
	public SocialMediaManager(JobSeekerDao jobSeekerDao, SocialMediaDao socialMediaDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.socialMediaDao = socialMediaDao;
	}

	@Override
	public Result add(SocialMedia socialMedia) {
		JobSeeker jobSeeker = new JobSeeker();
		jobSeeker.setId(socialMedia.getJobSeeker().getId());
		
		socialMedia.setJobSeeker(jobSeeker);
		
		this.socialMediaDao.save(socialMedia);
		return new SuccessResult("your social media information has been added.");
	}

	@Override
	public Result update(SocialMedia updateSocialMedia, int id) {
		SocialMedia socialMedia = socialMediaDao.findById(id);
		JobSeeker jobSeeker = jobSeekerDao.findById(updateSocialMedia.getJobSeeker().getId());
		
		updateSocialMedia.setJobSeeker(jobSeeker);
		
		this.socialMediaDao.save(socialMedia);
		return new SuccessResult("your social media information has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.socialMediaDao.deleteById(id);
		return new SuccessResult("your social media information has been deleted.");
	}

	@Override
	public DataResult<List<SocialMedia>> getAll() {
		return new SuccessDataResult<List<SocialMedia>>(this.socialMediaDao.findAll());
	}

	@Override
	public DataResult<SocialMedia> getById(int id) {
		return new SuccessDataResult<SocialMedia>(this.socialMediaDao.findById(id));
	}

}
