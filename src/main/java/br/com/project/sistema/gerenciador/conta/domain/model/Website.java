package br.com.project.sistema.gerenciador.conta.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("website")
public class Website {
    @Id
    private String id;
    private String name;
    private String url;
}
