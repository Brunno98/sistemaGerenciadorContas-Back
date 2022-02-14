package br.com.project.sistema.gerenciador.conta.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceAccountRequestDto {
    private Long accountId;
    private Long websiteId;
    private Map<String, Object> extra;
}
