package com.hrms.hrms.core.verifications.concretes;

import org.springframework.stereotype.Service;

import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.core.verifications.abstracts.HrmsVerificationService;
import com.hrms.hrms.entities.concretes.Employer;

@Service
public class HrmsVerificationManager implements HrmsVerificationService{

	@Override
	public Result isVerificatedByHrms(Employer employer) {
		// TODO Auto-generated method stub
		return new SuccessResult();
	}

}
