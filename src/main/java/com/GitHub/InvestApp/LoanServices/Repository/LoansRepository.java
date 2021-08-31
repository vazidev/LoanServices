package com.GitHub.InvestApp.LoanServices.Repository;

import com.GitHub.InvestApp.LoanServices.Domain.Loan;
import com.GitHub.InvestApp.LoanServices.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface LoansRepository extends ReactiveCassandraRepository<Loan, String> {
    static final Logger log = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("repo");
public default void logger(){
    log.info("Repo check....");
}

}
