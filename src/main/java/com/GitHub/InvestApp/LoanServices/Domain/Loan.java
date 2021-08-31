package com.GitHub.InvestApp.LoanServices.Domain;

import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Table("loans")
public class Loan {
    @Id
    @PrimaryKey private int account_id;
    Timestamp timestamp;
    double loan_amount;
    String purpose;
    double gross_earnings;
    double total_expenses;
    int loan_term;
    String loan_status;
    boolean approved;

    @PersistenceConstructor
    public Loan(int account_id, Timestamp timestamp, double loan_amount, String
            purpose, double gross_earnings, double total_expenses,
                int loan_term, String loan_status, boolean approved) {
        this.account_id = account_id;
        this.timestamp  = timestamp;
        this.loan_amount = loan_amount;
        this.purpose = purpose;
        this.gross_earnings = gross_earnings;
        this.total_expenses = total_expenses;
        this.loan_term  = loan_term;
        this.loan_status = loan_status;
        this.approved = approved;
    }

    @NonNull
    public static Loan from(Loan l){
        return new Loan(l.account_id, l.timestamp, l.loan_amount, l.purpose, l.gross_earnings,
                l.total_expenses, l.loan_term, l.loan_status, l.approved);
    }

    public void setTimestamp(){
       this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Date getTimestamp(){
        return timestamp;
    }

    public void setApproved(int val){
        this.approved = (val !=0);
    }


    /**
     * Getters and Setters Section
     *
     */

    public int getId() {
        return account_id;
    }

    public void setAccountId(int id) {
        this.account_id= id;
    }



    @Override
    public String toString() {
       return  "Timestamp: " +  timestamp
        + " Loan Amount: " + loan_amount
        + " Loan Purpose: " + purpose
        + " Annual Gross Earnings: " + gross_earnings
        + " Monthly Total Expsnses : " + total_expenses
        + " Loan Term (months): " + loan_term
        + " Application Status: " + loan_status
        + " Approval Status: " + approved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       Loan loan = (Loan) o;
        return Objects.equals(this.account_id, loan.account_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.account_id);
    }

}