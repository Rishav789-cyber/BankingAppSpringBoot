package com.banking.BankingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class AccountDTO {
    private Long id;
    private String accountHolderName;
    private double balance;
}
