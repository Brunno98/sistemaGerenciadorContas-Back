package br.com.project.sistema.gerenciador.conta.infraestructure.repository;

import br.com.project.sistema.gerenciador.conta.domain.model.Website;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WebsiteRepository extends MongoRepository<Website, String> {
}
