package br.com.project.sistema.gerenciador.conta.domain.service.impl;

import br.com.project.sistema.gerenciador.conta.domain.model.Website;
import br.com.project.sistema.gerenciador.conta.domain.service.WebsiteService;
import br.com.project.sistema.gerenciador.conta.infraestructure.repository.WebsiteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class WebsiteServiceImpl implements WebsiteService {
    private final WebsiteRepository websiteRepository;

    @Autowired
    public WebsiteServiceImpl(WebsiteRepository websiteRepository) {
        this.websiteRepository = websiteRepository;
    }

    @Override
    public List<Website> getAllWebsites() {
        log.info("getting all websites.");
        return websiteRepository.findAll();
    }

    @Override
    public Optional<Website> getWebsite(String id) {
        log.info("Getting website with id {}", id);
        return websiteRepository.findById(id);
    }

    @Override
    public Website createWebsite(Website website) {
        log.info("Creating website.");
        return websiteRepository.save(website);
    }

    @Override
    public Website updateWebsite(String id, Website website) {
        log.info("Updating website with id {}", id);
        website.setId(id);
        return websiteRepository.save(website);
    }

    @Override
    public void deleteWebsite(String id) {
        // TODO: should remove this website off all webSiteList of Account
        log.info("Deleting website with id {}", id);
        websiteRepository.deleteById(id);
    }
}
