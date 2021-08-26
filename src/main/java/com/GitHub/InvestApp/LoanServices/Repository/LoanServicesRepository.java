package com.GitHub.InvestApp.LoanServices.Repository;

import com.GitHub.InvestApp.LoanServices.LoanServicesApplication;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanServicesRepository extends ReactiveCassandraRepository<LoanServicesApplication,  String> {
}
