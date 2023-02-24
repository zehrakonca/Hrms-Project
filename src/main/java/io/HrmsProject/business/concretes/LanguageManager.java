package io.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.LanguageService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.LanguageDao;
import io.HrmsProject.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	
	private LanguageDao languageDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("language data has been saved.");
	}

	@Override
	public Result update(Language language, int id) {
		this.languageDao.findById(id);
		this.languageDao.save(language);
		return new SuccessResult("language data has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.languageDao.deleteById(id);
		return new SuccessResult("language has been deleted.");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
	}

	@Override
	public DataResult<Language> getById(int id) {
		return new SuccessDataResult<Language>(this.languageDao.findById(id));
	}

}
