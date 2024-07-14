package com.banking.BankingApp.mapper;

import com.banking.BankingApp.dto.AccountDTO;
import com.banking.BankingApp.model.BankAccountModel;

public class AccountMapper {
    public static BankAccountModel dtoToModel(AccountDTO accountDTO){
        BankAccountModel bankAccountModel=new BankAccountModel(accountDTO.getId(),accountDTO.getAccountHolderName(),accountDTO.getBalance());
        return bankAccountModel;
    }
    public static AccountDTO modelToDTO(BankAccountModel bankAccountModel){
        AccountDTO accountDTO=new AccountDTO(bankAccountModel.getId(),bankAccountModel.getAccountHolderName(),bankAccountModel.getBalance());
        return accountDTO;
    }
}
