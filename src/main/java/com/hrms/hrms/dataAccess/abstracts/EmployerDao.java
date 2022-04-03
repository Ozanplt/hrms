package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDao extends JpaRepository<Employer,Integer> {
	Employer getByCompanyEmail(String companyEmail);
}
