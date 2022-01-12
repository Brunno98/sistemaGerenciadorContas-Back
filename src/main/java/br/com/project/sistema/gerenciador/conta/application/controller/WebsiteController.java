package br.com.project.sistema.gerenciador.conta.application.controller;

import br.com.project.sistema.gerenciador.conta.domain.model.Website;
import br.com.project.sistema.gerenciador.conta.domain.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/website")
public class WebsiteController {

    private final WebsiteService service;

    @Autowired
    public WebsiteController(WebsiteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Website>> getAllWebsites() {
        return ResponseEntity.ok(service.getAllWebsites());
    }

    @GetMapping("{id}")
    public ResponseEntity<Website> getWebsite(@PathVariable String id) {
        Optional<Website> website = service.getWebsite(id);
        if (website.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(website.get());
    }

    @PostMapping
    public ResponseEntity<Website> createWebsite(@RequestBody Website website) {
        Website createdWebsite = service.createWebsite(website);
        return ResponseEntity.ok(createdWebsite);
    }

    @PutMapping("{id}")
    public ResponseEntity<Website> updateWebsite(@PathVariable String id, @RequestBody Website website) {
        Website updatedWebsite = service.updateWebsite(id, website);
        return ResponseEntity.ok(updatedWebsite);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteWebsite(@PathVariable String id) {
        service.deleteWebsite(id);
        return ResponseEntity.noContent().build();
    }


}
