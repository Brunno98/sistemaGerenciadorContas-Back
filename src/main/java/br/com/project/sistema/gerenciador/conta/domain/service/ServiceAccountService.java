package br.com.project.sistema.gerenciador.conta.domain.service;

import br.com.project.sistema.gerenciador.conta.domain.model.ServiceAccount;
import br.com.project.sistema.gerenciador.conta.domain.model.dto.ServiceAccountRequestDto;

import java.util.List;

public interface ServiceAccountService {

    ServiceAccount getServiceAccount(Long accountId, Long websiteId);

    List<ServiceAccount> getServiceAccountsByAccountId(Long accountId);

    ServiceAccount create(ServiceAccountRequestDto serviceAccountDto);

    ServiceAccount update(Long id, ServiceAccountRequestDto serviceAccountDto);

    void delete(Long id);

    List<ServiceAccount> getServiceAccounts(Long accountId, Long websiteId);

    ServiceAccount getServiceAccountById(Long id);
}
