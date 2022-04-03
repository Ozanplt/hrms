package com.hrms.hrms.core.adapters.concretes;

import com.hrms.hrms.core.adapters.abstracts.MernisCheckService;
import com.hrms.hrms.entities.concretes.JobSeeker;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;
@Service
public class MernisCheckManager implements MernisCheckService {



	@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) throws RemoteException {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		return kpsPublicSoapProxy.TCKimlikNoDogrula(jobSeeker.getNationalIdentityNo(), jobSeeker.getFirstName(),
				jobSeeker.getLastName(), jobSeeker.getYearOfBirth());
	}

}
