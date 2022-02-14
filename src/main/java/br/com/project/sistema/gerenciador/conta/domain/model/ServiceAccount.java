package br.com.project.sistema.gerenciador.conta.domain.model;

import br.com.project.sistema.gerenciador.conta.infraestructure.converter.HashMapConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Map;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ServiceAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonIgnoreProperties("serviceAccounts")
    private Account account;
    @ManyToOne
    @JsonIgnoreProperties("serviceAccounts")
    private Website website;

    @Convert(converter = HashMapConverter.class)
    private Map<String, Object> extra;
}
