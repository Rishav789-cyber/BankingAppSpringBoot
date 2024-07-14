package com.banking.BankingApp.controller;

import com.banking.BankingApp.dto.AccountDTO;
import com.banking.BankingApp.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;
@PostMapping
public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO){
    AccountDTO createdAccount=bankAccountService.createAccount(accountDTO);
    return new ResponseEntity<>(createdAccount,HttpStatus.CREATED);
}
@GetMapping("/{id}")
public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id){
    AccountDTO account=bankAccountService.getAccountDetailsById(id);
    return ResponseEntity.ok(account);
}
@GetMapping
public ResponseEntity<List<AccountDTO>> getAllAccounts(){
    return ResponseEntity.ok(bankAccountService.getAllAccounts());
}
@PutMapping("/{id}/withdraw")
public ResponseEntity<AccountDTO> withdrawAmount(@PathVariable Long id,@RequestBody Map<String,Double> accountMap){
    Double amt=accountMap.get("balance");
    return ResponseEntity.ok(bankAccountService.withdraw(id,amt));
}
@PutMapping("/{id}/deposit")
public ResponseEntity<AccountDTO> depositAmount(@PathVariable Long id,@RequestBody Map<String,Double> accountMap){
        Double amt=accountMap.get("balance");
        return ResponseEntity.ok(bankAccountService.deposit(id,amt));
    }
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteAccountById(@PathVariable Long id){
    bankAccountService.deleteAccount(id);
    return ResponseEntity.ok("Account deleted successfully");
}
}
