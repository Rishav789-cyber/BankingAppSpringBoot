package com.banking.BankingApp.service;

import com.banking.BankingApp.dto.AccountDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BankAccountService {

    AccountDTO createAccount(AccountDTO accountDTO);

    AccountDTO getAccountDetailsById(Long id);
    AccountDTO withdraw(Long id,double amount);
    AccountDTO deposit(Long id,double amount);
    List<AccountDTO> getAllAccounts();
    void deleteAccount(Long id);
}
