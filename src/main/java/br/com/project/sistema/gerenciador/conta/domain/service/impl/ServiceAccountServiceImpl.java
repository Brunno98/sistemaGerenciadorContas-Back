package br.com.project.sistema.gerenciador.conta.domain.service.impl;

import br.com.project.sistema.gerenciador.conta.domain.model.Account;
import br.com.project.sistema.gerenciador.conta.domain.model.Project;
import br.com.project.sistema.gerenciador.conta.domain.model.ServiceAccount;
import br.com.project.sistema.gerenciador.conta.domain.model.Website;
import br.com.project.sistema.gerenciador.conta.domain.model.dto.ServiceAccountDto;
import br.com.project.sistema.gerenciador.conta.domain.service.ServiceAccountService;
import br.com.project.sistema.gerenciador.conta.infraestructure.repository.AccountRepository;
import br.com.project.sistema.gerenciador.conta.infraestructure.repository.ProjectRepository;
import br.com.project.sistema.gerenciador.conta.infraestructure.repository.ServiceAccountRepository;
import br.com.project.sistema.gerenciador.conta.infraestructure.repository.WebsiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceAccountServiceImpl implements ServiceAccountService {

    private final ServiceAccountRepository repository;
    private final AccountRepository accountRepository;
    private final WebsiteRepository websiteRepository;
    private final ProjectRepository projectRepository;

    @Override
    public ServiceAccount getServiceAccount(String accountId, String websiteId) {
        return repository.findByAccountIdAndWebsiteId(accountId, websiteId)
                .orElseThrow(() -> new RuntimeException("service account not found. account and website: " + accountId + ", " + websiteId));
    }

    @Override
    public List<ServiceAccount> getServiceAccountsByAccountId(String accountId) {
        return repository.findAllByAccountId(accountId);
    }

    @Override
    public void create(ServiceAccountDto serviceAccountDto) {
        String accountId = serviceAccountDto.getAccountId();
        String websiteId = serviceAccountDto.getWebsiteId();
        String projectId = serviceAccountDto.getProjectId();

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("account not found. id: " + accountId));
        Website website = websiteRepository.findById(websiteId)
                .orElseThrow(() -> new RuntimeException("website not found. id:" + websiteId));
        Optional<Project> projectOptional = projectRepository.findById(projectId);
        ServiceAccount serviceAccount = ServiceAccount.builder()
                .account(account)
                .website(website)
                .project(projectOptional.orElse(null))
                .extra(serviceAccountDto.getExtra())
                .build();
        repository.save(serviceAccount);
    }

    @Override
    public void update(ServiceAccountDto serviceAccountDto) {

    }

    @Override
    public void delete(ServiceAccountDto serviceAccountDto) {
        String accountId = serviceAccountDto.getAccountId();
        String websiteId = serviceAccountDto.getWebsiteId();
        repository.deleteByAccountIdAndWebsiteId(accountId, websiteId);
    }

    @Override
    public List<ServiceAccount> getServiceAccounts(String accountId, String websiteId) {
        if (Objects.isNull(websiteId)) {
            return this.getServiceAccountsByAccountId(accountId);
        } else {
            return List.of(this.getServiceAccount(accountId, websiteId));
        }
    }
}
