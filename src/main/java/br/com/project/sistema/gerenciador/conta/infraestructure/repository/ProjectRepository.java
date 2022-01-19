package br.com.project.sistema.gerenciador.conta.infraestructure.repository;

import br.com.project.sistema.gerenciador.conta.domain.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {
}
