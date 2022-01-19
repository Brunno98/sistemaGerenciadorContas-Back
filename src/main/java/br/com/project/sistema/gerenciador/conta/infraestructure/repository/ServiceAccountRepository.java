package br.com.project.sistema.gerenciador.conta.infraestructure.repository;

import br.com.project.sistema.gerenciador.conta.domain.model.Project;
import br.com.project.sistema.gerenciador.conta.domain.model.ServiceAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.security.Provider;
import java.util.List;
import java.util.Optional;

public interface ServiceAccountRepository extends MongoRepository<ServiceAccount, String> {
    List<ServiceAccount> findAllByAccountId(String id);

    List<ServiceAccount> findAllByProjectId(String id);

    Optional<ServiceAccount> findByAccountIdAndWebsiteId(String accountId, String websiteId);

    void deleteByAccountIdAndWebsiteId(String accountId, String websiteId);

    void deleteAllByAccountId(String id);
}
