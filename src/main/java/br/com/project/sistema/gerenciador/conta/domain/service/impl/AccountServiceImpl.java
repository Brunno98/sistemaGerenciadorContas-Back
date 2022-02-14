package br.com.project.sistema.gerenciador.conta.domain.service.impl;

import br.com.project.sistema.gerenciador.conta.domain.model.Account;
import br.com.project.sistema.gerenciador.conta.domain.service.AccountService;
import br.com.project.sistema.gerenciador.conta.infraestructure.repository.AccountRepository;
import br.com.project.sistema.gerenciador.conta.infraestructure.repository.ServiceAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
            return accountRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        } catch (RuntimeException e) {
            log.warn("Erro while get all accounts.", e);
            return Collections.emptyList();
        }
    }

    @Override
    public Account getAccount(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isEmpty()) {
            log.warn("Account with id {} not found", id);
        }
        return account.get();
    }

    @Override
    public Account updateAccount(Long id, Account account) {
        try {
            Account currentAccount = accountRepository.findById(id).orElseThrow(() -> {
                log.warn("Account with id {} not found", id);
                return new RuntimeException("id not found");
            });
            account.setId(currentAccount.getId());
            account.setServiceAccounts(currentAccount.getServiceAccounts());
            return accountRepository.save(account);
        } catch (Exception e) {
            log.warn("Error while updating account");
            throw e;
        }

    }

    @Override
    public Boolean deleteAccount(Long id) {
        try {
            log.info("Deleting account with id {}", id);
            accountRepository.deleteById(id);
            return true;
        } catch (RuntimeException e) {
            log.warn("Error while deleting account with id {}", id, e);
            return false;
        }

    }
}
