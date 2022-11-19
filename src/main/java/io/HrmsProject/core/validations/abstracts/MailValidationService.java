package io.HrmsProject.core.validations.abstracts;

import io.HrmsProject.core.utilities.results.Result;

public interface MailValidationService {
	
	Result validate(String email) throws Exception;

}
