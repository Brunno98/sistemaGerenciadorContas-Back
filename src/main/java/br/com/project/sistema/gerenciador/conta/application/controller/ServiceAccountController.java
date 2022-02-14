package br.com.project.sistema.gerenciador.conta.application.controller;

import br.com.project.sistema.gerenciador.conta.domain.model.ServiceAccount;
import br.com.project.sistema.gerenciador.conta.domain.model.dto.ServiceAccountRequestDto;
import br.com.project.sistema.gerenciador.conta.domain.service.ServiceAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("serviceAccount")
public class ServiceAccountController {

    private final ServiceAccountService service;

    @Autowired
    public ServiceAccountController(ServiceAccountService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ServiceAccount>> getServiceAccountsByAccountId(
            @RequestParam(required = true) Long accountId,
            @RequestParam(required = false) Long websiteId
    ) {
        List<ServiceAccount> serviceAccounts = service.getServiceAccounts(accountId, websiteId);
        if (serviceAccounts.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(serviceAccounts);
    }

    @GetMapping("{id}")
    public ResponseEntity<ServiceAccount> getServiceAccountById(@PathVariable Long id) {
        ServiceAccount serviceAccount = service.getServiceAccountById(id);
        if (Objects.isNull(serviceAccount)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(serviceAccount);
    }

    @PostMapping
    public ResponseEntity<ServiceAccount> createServiceAccount(@RequestBody ServiceAccountRequestDto serviceAccountDto) {
        ServiceAccount serviceAccount = service.create(serviceAccountDto);
        return ResponseEntity.ok(serviceAccount);
    }

    @PutMapping("{id}")
    public ResponseEntity<ServiceAccount> updateServiceAccount(@PathVariable Long id, @RequestBody ServiceAccountRequestDto serviceAccountDto) {
        ServiceAccount updatedServiceAccount = service.update(id, serviceAccountDto);
        return ResponseEntity.ok(updatedServiceAccount);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteServiceAccount(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
