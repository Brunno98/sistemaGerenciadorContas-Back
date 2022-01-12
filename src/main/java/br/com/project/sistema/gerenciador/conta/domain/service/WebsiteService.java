package br.com.project.sistema.gerenciador.conta.domain.service;

import br.com.project.sistema.gerenciador.conta.domain.model.Website;

import java.util.List;
import java.util.Optional;

public interface WebsiteService {
    List<Website> getAllWebsites();
    Optional<Website> getWebsite(String id);
    Website createWebsite(Website website);
    Website updateWebsite(String id, Website website);
    void deleteWebsite(String id);
}
