package io.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.LanguageInfoService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.JobSeekerDao;
import io.HrmsProject.dataAccess.abstracts.LanguageDao;
import io.HrmsProject.dataAccess.abstracts.LanguageInfoDao;
import io.HrmsProject.entities.concretes.JobSeeker;
import io.HrmsProject.entities.concretes.Language;
import io.HrmsProject.entities.concretes.LanguageInfo;

@Service
public class LanguageInfoManager implements LanguageInfoService{
	
	private LanguageDao languageDao;
	private JobSeekerDao jobSeekerDao;
	private LanguageInfoDao languageInfoDao;
	
	@Autowired
	public LanguageInfoManager(LanguageDao languageDao, JobSeekerDao jobSeekerDao,LanguageInfoDao languageInfoDao) {
		super();
		this.languageDao = languageDao;
		this.jobSeekerDao = jobSeekerDao;
		this.languageInfoDao = languageInfoDao;
	}

	@Override
	public Result add(LanguageInfo languageInfo) {
		Language language = new Language();
		JobSeeker jobSeeker = new JobSeeker();
		
		language.setLanguageId(languageInfo.getLanguage().getLanguageId());
		jobSeeker.setId(languageInfo.getJobSeeker().getId());
		
		languageInfo.setJobSeeker(jobSeeker);
		languageInfo.setLanguage(language);
		
		this.languageInfoDao.save(languageInfo);
		return new SuccessResult("your language information has been added.");
	}


	@Override
	public Result update(LanguageInfo updateLanguage, int id) {
		LanguageInfo languageInfo = languageInfoDao.findById(id);
		
		JobSeeker jobSeeker = jobSeekerDao.findById(updateLanguage.getJobSeeker().getId());
		Language language = languageDao.findById(updateLanguage.getLanguage().getLanguageId());
		
		updateLanguage.setJobSeeker(jobSeeker);
		updateLanguage.setLanguage(language);
		
		this.languageInfoDao.save(languageInfo);
		return new SuccessResult("your language information has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.languageInfoDao.deleteById(id);
		return new SuccessResult("your language information has been deleted.");
	}

	@Override
	public DataResult<List<LanguageInfo>> getAll() {
		return new SuccessDataResult<List<LanguageInfo>>(this.languageInfoDao.findAll());
	}

	@Override
	public DataResult<LanguageInfo> getById(int id) {
		return new SuccessDataResult<LanguageInfo>(this.languageInfoDao.findById(id));
	}

}
