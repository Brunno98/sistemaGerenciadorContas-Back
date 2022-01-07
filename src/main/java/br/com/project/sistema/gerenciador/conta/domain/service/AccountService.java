package br.com.project.sistema.gerenciador.conta.domain.service;

import br.com.project.sistema.gerenciador.conta.domain.model.Account;
import br.com.project.sistema.gerenciador.conta.infraestructure.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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
}
