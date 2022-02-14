package br.com.project.sistema.gerenciador.conta.domain.service;

import br.com.project.sistema.gerenciador.conta.domain.model.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    List<Account> getAccounts();
    Account getAccount(Long id);
    Account updateAccount(Long id, Account account);
    Boolean deleteAccount(Long id);
}
