package br.com.project.sistema.gerenciador.conta.application.controller;

import br.com.project.sistema.gerenciador.conta.domain.model.Account;
import br.com.project.sistema.gerenciador.conta.domain.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountServiceImpl accountService;

    @Autowired
    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public ResponseEntity<List<Account>> getAccounts() {
        List<Account> accounts = accountService.getAccounts();
        if (accounts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("{id}")
    public ResponseEntity<Account> getAccount(@PathVariable String id) {
        Optional<Account> optionalAccount = accountService.getAccount(id);
        if (optionalAccount.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalAccount.get());
    }

    @PostMapping
    public  ResponseEntity<?> createAccount (@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        if (Objects.isNull(createdAccount)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(createdAccount);
    }

    @PutMapping("{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable String id, @RequestBody Account account) {
        Account editedAccount = accountService.updateAccount(id, account);
        if (Objects.isNull(editedAccount)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(editedAccount);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAccount (@PathVariable String id) {
        Boolean deleted = accountService.deleteAccount(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
