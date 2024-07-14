package com.banking.BankingApp.service;

import com.banking.BankingApp.dto.AccountDTO;
import com.banking.BankingApp.mapper.AccountMapper;
import com.banking.BankingApp.model.BankAccountModel;
import com.banking.BankingApp.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        BankAccountModel bankAccountModel= AccountMapper.dtoToModel(accountDTO);
        BankAccountModel savedBankAccountModel=bankAccountRepository.save(bankAccountModel);
        return AccountMapper.modelToDTO(savedBankAccountModel);
    }

    @Override
    public AccountDTO getAccountDetailsById(Long id) {
        BankAccountModel bankAccountModel=bankAccountRepository.findById(id).get();
        return AccountMapper.modelToDTO(bankAccountModel);
    }

    @Override
    public AccountDTO withdraw(Long id,double amount) {
        BankAccountModel bankAccountModel=bankAccountRepository.findById(id).get();
        double balance=bankAccountModel.getBalance();
        if(balance<amount){
            throw new RuntimeException("Insufficient funds");
        }else{
            balance=balance-amount;
            bankAccountModel.setBalance(balance);
            bankAccountRepository.save(bankAccountModel);
        }
        return AccountMapper.modelToDTO(bankAccountModel);
    }

    @Override
    public AccountDTO deposit(Long id,double amount) {
        BankAccountModel bankAccountModel=bankAccountRepository.findById(id).get();
        double balance=bankAccountModel.getBalance();
        balance=balance+amount;
        bankAccountModel.setBalance(balance);
        bankAccountRepository.save(bankAccountModel);
        return AccountMapper.modelToDTO(bankAccountModel);
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<BankAccountModel> bankAccountModels=bankAccountRepository.findAll();
        return bankAccountModels.stream().map((bankAccountModel)->AccountMapper.modelToDTO(bankAccountModel)).collect(Collectors.toList());
    }
    @Override
    public void deleteAccount(Long id){
        bankAccountRepository.deleteById(id);
    }
}
