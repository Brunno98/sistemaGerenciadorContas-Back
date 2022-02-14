package br.com.project.sistema.gerenciador.conta.infraestructure.repository;

import br.com.project.sistema.gerenciador.conta.domain.model.ServiceAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServiceAccountRepository extends JpaRepository<ServiceAccount, Long> {

    Optional<ServiceAccount> findByAccountIdAndWebsiteId(Long accountId, Long websiteId);

    List<ServiceAccount> findAllByAccountId(Long accountId);
}
