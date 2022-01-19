package br.com.project.sistema.gerenciador.conta.domain.service;

import br.com.project.sistema.gerenciador.conta.domain.model.ServiceAccount;
import br.com.project.sistema.gerenciador.conta.domain.model.dto.ServiceAccountDto;

import java.util.List;

public interface ServiceAccountService {

    ServiceAccount getServiceAccount(String accountId, String websiteId);

    List<ServiceAccount> getServiceAccountsByAccountId(String accountId);

    void create(ServiceAccountDto serviceAccountDto);

    void update(ServiceAccountDto serviceAccountDto);

    void delete(ServiceAccountDto serviceAccountDto);

    List<ServiceAccount> getServiceAccounts(String accountId, String websiteId);
}
