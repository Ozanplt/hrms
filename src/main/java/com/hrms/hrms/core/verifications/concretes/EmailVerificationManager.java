package com.hrms.hrms.core.verifications.concretes;

import org.springframework.stereotype.Service;

import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.core.verifications.abstracts.EmailVerificationService;

@Service
public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public Result verifyEmail(String email) {
		// TODO Auto-generated method stub
		return new SuccessResult();
	}

}
