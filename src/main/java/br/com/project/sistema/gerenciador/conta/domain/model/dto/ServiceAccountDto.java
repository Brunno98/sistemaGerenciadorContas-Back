package br.com.project.sistema.gerenciador.conta.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceAccountDto {
    private String accountId;
    private String websiteId;
    private String projectId;
    private Map<String, String> extra;
}
