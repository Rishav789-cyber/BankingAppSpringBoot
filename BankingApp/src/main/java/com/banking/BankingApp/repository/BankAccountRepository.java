package com.banking.BankingApp.repository;

import com.banking.BankingApp.model.BankAccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountModel,Long> {
}
