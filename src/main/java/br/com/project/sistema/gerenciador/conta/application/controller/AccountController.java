package br.com.project.sistema.gerenciador.conta.application.controller;

import br.com.project.sistema.gerenciador.conta.domain.model.Account;
import br.com.project.sistema.gerenciador.conta.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
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

    @PostMapping
    public  ResponseEntity<?> createAccount (@RequestBody Account account) {
        Account createdAccunt = accountService.createAccount(account);
        if (Objects.isNull(createdAccunt)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(createdAccunt);
    }
}
