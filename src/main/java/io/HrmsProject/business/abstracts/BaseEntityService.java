package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;

public interface BaseEntityService<T,TAdd, TUpdate, TGet> {
	
	Result add(TAdd createEntity) throws Exception;
	Result update (TUpdate updateEntity) throws Exception;
	Result delete (int id);
	
	public DataResult<List<TGet>> getAll();

}
