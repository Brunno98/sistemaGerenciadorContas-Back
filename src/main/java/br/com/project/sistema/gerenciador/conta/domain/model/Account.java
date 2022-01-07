package br.com.project.sistema.gerenciador.conta.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("account")
public class Account {
    @Id
    private String id;
    private String gmail;
    private String password;
    private List<String> websites;
    private String project;
}
