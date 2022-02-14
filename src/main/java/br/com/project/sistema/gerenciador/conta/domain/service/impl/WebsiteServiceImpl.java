package br.com.project.sistema.gerenciador.conta.domain.service.impl;

import br.com.project.sistema.gerenciador.conta.domain.model.Website;
import br.com.project.sistema.gerenciador.conta.domain.service.WebsiteService;
import br.com.project.sistema.gerenciador.conta.infraestructure.repository.WebsiteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Website getWebsite(Long id) {
        log.info("Getting website with id {}", id);
        return websiteRepository.findById(id).orElseThrow(() -> {
            log.warn("website not found for id {}.", id);
            return new RuntimeException("website not found for id " + id);
        });
    }

    @Override
    public Website createWebsite(Website website) {
        log.info("Creating website.");
        return websiteRepository.save(website);
    }

    @Override
    public Website updateWebsite(Long id, Website website) {
        log.info("Updating website with id {}", id);
        Website currentWebsite = websiteRepository.findById(id).orElseThrow(() -> {
            log.warn("Website not found with id {}.", id);
            return new RuntimeException("Website not found with id " + id);
        });

        website.setId(id);
        website.setServiceAccounts(currentWebsite.getServiceAccounts());
        return websiteRepository.save(website);
    }

    @Override
    public void deleteWebsite(Long id) {
        log.info("Deleting website with id {}", id);
        websiteRepository.deleteById(id);
    }
}
