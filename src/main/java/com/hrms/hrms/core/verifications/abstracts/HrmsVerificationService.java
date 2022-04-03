package com.hrms.hrms.core.verifications.abstracts;

import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Employer;

public interface HrmsVerificationService {
	public Result isVerificatedByHrms(Employer employer);
}
