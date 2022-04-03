package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer> {
    boolean getBynationalIdentityNo(Long nationalIdentityNo);
    boolean getByEmail(String email);

}
