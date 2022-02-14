package br.com.project.sistema.gerenciador.conta.domain.service.impl;

import br.com.project.sistema.gerenciador.conta.domain.model.Account;
import br.com.project.sistema.gerenciador.conta.domain.model.ServiceAccount;
import br.com.project.sistema.gerenciador.conta.domain.model.Website;
import br.com.project.sistema.gerenciador.conta.domain.model.dto.ServiceAccountRequestDto;
import br.com.project.sistema.gerenciador.conta.domain.service.ServiceAccountService;
import br.com.project.sistema.gerenciador.conta.infraestructure.repository.AccountRepository;
import br.com.project.sistema.gerenciador.conta.infraestructure.repository.ServiceAccountRepository;
import br.com.project.sistema.gerenciador.conta.infraestructure.repository.WebsiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ServiceAccountServiceImpl implements ServiceAccountService {

    private final ServiceAccountRepository repository;
    private final AccountRepository accountRepository;
    private final WebsiteRepository websiteRepository;

    @Override
    public ServiceAccount getServiceAccount(Long accountId, Long websiteId) {
        return repository.findByAccountIdAndWebsiteId(accountId, websiteId)
                .orElseThrow(() -> new RuntimeException("service account not found. account and website: " + accountId + ", " + websiteId));
    }

    @Override
    public List<ServiceAccount> getServiceAccountsByAccountId(Long accountId) {
        return repository.findAllByAccountId(accountId);
    }

    @Override
    public ServiceAccount getServiceAccountById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("serviceAccount not found with id " + id));
    }

    @Override
    public ServiceAccount create(ServiceAccountRequestDto serviceAccountDto) {
        Long accountId = serviceAccountDto.getAccountId();
        Long websiteId = serviceAccountDto.getWebsiteId();

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("account not found. id: " + accountId));
        Website website = websiteRepository.findById(websiteId)
                .orElseThrow(() -> new RuntimeException("website not found. id:" + websiteId));

        ServiceAccount serviceAccount = ServiceAccount.builder()
                .account(account)
                .website(website)
                .extra(serviceAccountDto.getExtra())
                .build();
        return repository.save(serviceAccount);
    }

    @Override
    public ServiceAccount update(Long id, ServiceAccountRequestDto serviceAccountDto) {
        ServiceAccount currentServiceAccount = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ServiceAccount not found with id " + id));
        Website website = websiteRepository.findById(serviceAccountDto.getWebsiteId())
                .orElseThrow(() -> new RuntimeException("website not found with id " + id));

        currentServiceAccount.setWebsite(website);
        currentServiceAccount.setExtra(serviceAccountDto.getExtra());

        return repository.save(currentServiceAccount);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ServiceAccount> getServiceAccounts(Long accountId, Long websiteId) {
        if (Objects.isNull(websiteId)) {
            return this.getServiceAccountsByAccountId(accountId);
        } else {
            return List.of(this.getServiceAccount(accountId, websiteId));
        }
    }
}
