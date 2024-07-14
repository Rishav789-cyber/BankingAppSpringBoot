package com.banking.BankingApp.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bankAccount")
public class BankAccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="accountHolderName")
    private String accountHolderName;
    @Column(name="balance")
    private double balance;
}
