package br.com.project.sistema.gerenciador.conta.domain.service;

import br.com.project.sistema.gerenciador.conta.domain.model.Account;
import br.com.project.sistema.gerenciador.conta.infraestructure.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        try{
            return accountRepository.save(account);
        } catch (RuntimeException e) {
            log.warn("Erro while creating account. ", e);
            return null;
        }
    }

    public List<Account> getAccounts() {
        try {
            return accountRepository.findAll();
        } catch (RuntimeException e) {
            log.warn("Erro while get all accounts.", e);
            return Collections.emptyList();
        }
    }

    public Optional<Account> getAccount(String id) {
        return accountRepository.findById(id).or(() -> {
            log.warn("Account with id {} not found", id);
            return Optional.empty();
        });
    }

    public Account updateAccount(String id, Account account) {
        try {
            account.setId(id);
            return accountRepository.save(account);
        } catch (Exception e) {
            log.warn("Error while updating account");
            throw e;
        }

    }

    public Boolean deleteAccount(String id) {
        try {
            accountRepository.deleteById(id);
            return true;
        } catch (RuntimeException e) {
            log.warn("Erro while deleting account with id {}", id);
            return false;
        }

    }
}
