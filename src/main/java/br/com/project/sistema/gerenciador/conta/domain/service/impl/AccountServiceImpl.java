package br.com.project.sistema.gerenciador.conta.domain.service.impl;

import br.com.project.sistema.gerenciador.conta.domain.model.Account;
import br.com.project.sistema.gerenciador.conta.domain.service.AccountService;
import br.com.project.sistema.gerenciador.conta.infraestructure.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        try{
            return accountRepository.save(account);
        } catch (RuntimeException e) {
            log.warn("Erro while creating account. ", e);
            return null;
        }
    }

    @Override
    public List<Account> getAccounts() {
        try {
            return accountRepository.findAll();
        } catch (RuntimeException e) {
            log.warn("Erro while get all accounts.", e);
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<Account> getAccount(String id) {
        return accountRepository.findById(id).or(() -> {
            log.warn("Account with id {} not found", id);
            return Optional.empty();
        });
    }

    @Override
    public Account updateAccount(String id, Account account) {
        try {
            account.setId(id);
            return accountRepository.save(account);
        } catch (Exception e) {
            log.warn("Error while updating account");
            throw e;
        }

    }

    @Override
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
