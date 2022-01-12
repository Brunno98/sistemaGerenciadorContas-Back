package br.com.project.sistema.gerenciador.conta.domain.service;

import br.com.project.sistema.gerenciador.conta.domain.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Account createAccount(Account account);
    List<Account> getAccounts();
    Optional<Account> getAccount(String id);
    Account updateAccount(String id, Account account);
    Boolean deleteAccount(String id);
}
