package br.com.project.sistema.gerenciador.conta.domain.service;

import br.com.project.sistema.gerenciador.conta.domain.model.Website;

import java.util.List;

public interface WebsiteService {
    List<Website> getAllWebsites();
    Website getWebsite(Long id);
    Website createWebsite(Website website);
    Website updateWebsite(Long id, Website website);
    void deleteWebsite(Long id);
}
