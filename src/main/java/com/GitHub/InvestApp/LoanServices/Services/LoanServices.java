package com.GitHub.InvestApp.LoanServices.Services;

import com.GitHub.InvestApp.LoanServices.LoanServicesApplication;
import com.GitHub.InvestApp.LoanServices.Repository.LoanServicesRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LoanServices {
  private final LoanServicesRepository loanServicesRepository;

  public LoanServices(LoanServicesRepository loanServicesRepository) { this.loanServicesRepository = loanServicesRepository; }

    public Flux<LoanServicesApplication> getAll() { return this.loanServicesRepository.findAll();} //findall

    public Mono<LoanServicesApplication> get(String uid) {return loanServicesRepository.findById(uid);} //find by ID

    //public Mono<newEntry> create(NewEntry newEntry) { return loanServicesRepository.save(newEntry);} //Crete new Account


}
