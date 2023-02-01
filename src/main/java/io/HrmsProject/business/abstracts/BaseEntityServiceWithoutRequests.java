package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;

public interface BaseEntityServiceWithoutRequests<T> {
	Result add(T entity);
	Result update (T entity, int id);
	Result delete (int id);
	DataResult<List<T>> getAll();
	DataResult<T> getById(int id);
}
