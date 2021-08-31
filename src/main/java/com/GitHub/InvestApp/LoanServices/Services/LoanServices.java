package com.GitHub.InvestApp.LoanServices.Services;

import com.GitHub.InvestApp.LoanServices.Domain.Loan;
import com.GitHub.InvestApp.LoanServices.Repository.LoansRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LoanServices {
    private static final Logger log = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("service");

    @Autowired
    private final LoansRepository loanRepo;

    public LoanServices(LoansRepository loanRepo) {
        this.loanRepo = loanRepo;
    }


    public Flux<Loan>  findAll() {
        log.info("Query @Service");
      return  loanRepo.findAll();
    }

    public Mono<Loan> create(Loan loan) {
        return loanRepo.save(loan);
    }

    public Mono<Loan> getByUid(String id) {
        return loanRepo.findById(id);
    }

    public Mono<Loan> get(String id){
        return loanRepo.findById(id);
    }

    public Mono<Loan> getByID(int id) {
      return loanRepo.findById(String.valueOf(id));
    }

    public Mono<Void> delete(Integer id) {
        return loanRepo.deleteById(String.valueOf(id));
    }


/*** TODO **/

    public void updateStatus(Integer id, String status) {
    // return loanRepo.insert(id,status);
}

    public Mono<Loan> updateApproval(int id, boolean b) {
        // return loanRepo.insert( id,  b);
        return null;
    }



    public void cancelApplication(int[] id) {
       // loanRepo.insert( id)
    }


}