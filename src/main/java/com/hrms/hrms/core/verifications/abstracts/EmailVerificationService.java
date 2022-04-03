package com.hrms.hrms.core.verifications.abstracts;

import com.hrms.hrms.core.utilities.results.Result;

public interface EmailVerificationService {
	public Result verifyEmail(String email);

}
