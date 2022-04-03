package com.hrms.hrms.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
    Result add(JobSeeker jobSeeker) throws RemoteException;
    DataResult<List<JobSeeker>> getAll();
}
