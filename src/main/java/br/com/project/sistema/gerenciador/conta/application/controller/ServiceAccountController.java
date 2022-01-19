package br.com.project.sistema.gerenciador.conta.application.controller;

import br.com.project.sistema.gerenciador.conta.domain.model.ServiceAccount;
import br.com.project.sistema.gerenciador.conta.domain.model.dto.ServiceAccountDto;
import br.com.project.sistema.gerenciador.conta.domain.service.ServiceAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("serviceAccount")
public class ServiceAccountController {

    private final ServiceAccountService service;

    @Autowired
    public ServiceAccountController(ServiceAccountService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ServiceAccount>> getServiceAccountByAccountId(
            @RequestParam(required = true) String accountId,
            @RequestParam(required = false) String websiteId
    ) {
        List<ServiceAccount> serviceAccounts = service.getServiceAccounts(accountId, websiteId);
        if (serviceAccounts.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(serviceAccounts);
    }

    @PostMapping
    public ResponseEntity<?> createServiceAccount(@RequestBody ServiceAccountDto serviceAccountDto) {
        service.create(serviceAccountDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteServiceAccount(@RequestBody ServiceAccountDto serviceAccountDto) {
        service.delete(serviceAccountDto);
        return ResponseEntity.ok().build();
    }
}
