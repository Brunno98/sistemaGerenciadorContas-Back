package br.com.project.sistema.gerenciador.conta.infraestructure.repository;

import br.com.project.sistema.gerenciador.conta.domain.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebsiteRepository extends JpaRepository<Website, Long> {
}
