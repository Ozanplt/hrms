package com.hrms.hrms.business.concretes;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.JobSeekerService;
import com.hrms.hrms.core.adapters.abstracts.MernisCheckService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.core.verifications.abstracts.EmailVerificationService;
import com.hrms.hrms.dataAccess.abstracts.JobSeekerDao;
import com.hrms.hrms.entities.concretes.JobSeeker;
@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private MernisCheckService mernisCheckService;
    private EmailVerificationService emailVerificationService;
    

    public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisCheckService mernisCheckService,EmailVerificationService emailVerificationService) {
        this.jobSeekerDao = jobSeekerDao;
        this.mernisCheckService = mernisCheckService;
        this.emailVerificationService = emailVerificationService;
    }


    @Override
    public Result add(JobSeeker jobSeeker) throws RemoteException {
        if(!mernisCheckService.checkIfRealPerson(jobSeeker) && existsIfEmail(jobSeeker.getEmail()).isSuccess() &&
                existsIfnationalIdentityNo(jobSeeker.getNationalIdentityNo()).isSuccess()){
            jobSeekerDao.save(jobSeeker);
            return new SuccessResult("Job Seeker has registered successfully");

        }
        else{
            return new ErrorResult("Informations you entered are incorrect");
        }
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(),"İş arayan bilgileri listelendi");
    }
    
    public Result existsIfEmail(String email) {
    	if(this.jobSeekerDao.getByEmail(email)) {
    		return new ErrorResult("Email is already exists");
    	}
    	else {
    		return new SuccessResult();
    	}
    }
    
    public Result existsIfnationalIdentityNo(long nationalIdentityNo) {
    	if(this.jobSeekerDao.getBynationalIdentityNo(nationalIdentityNo)) {
    		return new ErrorResult("Bu Tc No ile sisteme daha önce kaydolunmuştur");
    	}
    	else {
    		return new SuccessResult();
    	}
    	
    }
    

    
}
