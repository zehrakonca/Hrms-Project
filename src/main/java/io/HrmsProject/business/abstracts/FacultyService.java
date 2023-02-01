package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.Faculty;

public interface FacultyService extends BaseEntityServiceWithoutRequests<Faculty>{
	
	DataResult<List<Faculty>> getByFacultyName(String facultyName);
}
