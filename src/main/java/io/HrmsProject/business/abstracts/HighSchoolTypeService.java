package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.entities.concretes.HighSchoolType;

public interface HighSchoolTypeService {
	
	Result add(HighSchoolType highSchoolType);
	Result delete(int id);
	
	DataResult<List<HighSchoolType>> getAll();
	DataResult<HighSchoolType> getById(int id);

}
