package br.com.project.sistema.gerenciador.conta.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("serviceAccount")
public class ServiceAccount {
    @Id
    private String id;
    private Account account;
    private Website website;
    private Project project;
    private Map<String, String> extra;
}
