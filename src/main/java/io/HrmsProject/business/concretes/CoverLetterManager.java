package io.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.CoverLetterService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.CoverLetterDao;
import io.HrmsProject.dataAccess.abstracts.JobSeekerDao;
import io.HrmsProject.entities.concretes.CoverLetter;
import io.HrmsProject.entities.concretes.JobSeeker;

@Service
public class CoverLetterManager implements CoverLetterService{
	
	private JobSeekerDao jobSeekerDao;
	private CoverLetterDao coverLetterDao;
	
	@Autowired
	public CoverLetterManager(JobSeekerDao jobSeekerDao, CoverLetterDao coverLetterDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		JobSeeker jobSeeker = new JobSeeker();
		jobSeeker.setId(coverLetter.getJobSeeker().getId());
		
		coverLetter.setJobSeeker(jobSeeker);
		
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("your cover letter has been saved.");
	}

	@Override
	public Result update(CoverLetter coverLetter, int id) {
		CoverLetter updateCoverLetter = coverLetterDao.findById(id);
		JobSeeker jobSeeker = jobSeekerDao.findById(coverLetter.getJobSeeker().getId());
		
		coverLetter.setJobSeeker(jobSeeker);
		
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("your cover letter has been updated.");
		
	}

	@Override
	public Result delete(int id) {
		this.coverLetterDao.deleteById(id);
		return new SuccessResult("your cover letter has been deleted.");
	}

	@Override
	public DataResult<List<CoverLetter>> getAll() {
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.findAll());
	}

	@Override
	public DataResult<CoverLetter> getById(int id) {
		return new SuccessDataResult<CoverLetter>(this.coverLetterDao.findById(id));
	}

}
