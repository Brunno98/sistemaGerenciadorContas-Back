package br.com.project.sistema.gerenciador.conta.infraestructure.repository;

import br.com.project.sistema.gerenciador.conta.domain.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
}
