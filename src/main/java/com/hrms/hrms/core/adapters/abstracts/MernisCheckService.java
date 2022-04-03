package com.hrms.hrms.core.adapters.abstracts;

import com.hrms.hrms.entities.concretes.JobSeeker;

import java.rmi.RemoteException;

public interface MernisCheckService {
    boolean checkIfRealPerson(JobSeeker jobSeeker) throws RemoteException;
}
