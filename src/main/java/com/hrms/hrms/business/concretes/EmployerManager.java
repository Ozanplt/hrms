package com.hrms.hrms.business.concretes;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.EmployerService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.core.verifications.abstracts.EmailVerificationService;
import com.hrms.hrms.core.verifications.abstracts.HrmsVerificationService;
import com.hrms.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.hrms.entities.concretes.Employer;


@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private HrmsVerificationService hrmsVerificationService;
	private EmailVerificationService emailVerificationService;


	public EmployerManager(EmployerDao employerDao, HrmsVerificationService hrmsVerificationService,
			EmailVerificationService emailVerificationService) {

		this.employerDao = employerDao;
		this.hrmsVerificationService = hrmsVerificationService;
		this.emailVerificationService = emailVerificationService;
	}

	@Override
	public Result add(Employer employer) {
		if(!ifEmailExists(employer.getCompanyEmail()).isSuccess()) {
			return new ErrorResult("email already exist");
		}
		
		if(!this.hrmsVerificationService.isVerificatedByHrms(employer).isSuccess()) {
			return new ErrorResult("Employer was not verificated from HRMS personal!");
		}
		
		if(!this.emailVerificationService.verifyEmail(employer.getCompanyEmail()).isSuccess()) {
			return new ErrorResult("Check your email please");
		}
		
		this.employerDao.save(employer);
		return new SuccessResult("Employer added");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Data listed.")  ;
	}
	
	public Result ifEmailExists(String companyEmail) {
		if(employerDao.getByCompanyEmail(companyEmail)!=null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
}
	
