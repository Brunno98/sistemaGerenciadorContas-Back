//package br.com.project.sistema.gerenciador.conta.domain.service.impl;
//
//import br.com.project.sistema.gerenciador.conta.domain.model.Project;
//import br.com.project.sistema.gerenciador.conta.domain.model.ServiceAccount;
//import br.com.project.sistema.gerenciador.conta.domain.service.ProjectService;
//import br.com.project.sistema.gerenciador.conta.infraestructure.repository.ProjectRepository;
//import br.com.project.sistema.gerenciador.conta.infraestructure.repository.ServiceAccountRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProjectServiceImpl implements ProjectService {
//
//    @Autowired
//    private ProjectRepository repository;
//    @Autowired
//    private ServiceAccountRepository serviceAccountRepository;
//
//    @Override
//    public Project create(Project project) {
//        return repository.save(project);
//    }
//
//    @Override
//    public Project getProject(String id) {
//        return repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Project not found. id:" + id));
//    }
//
//    @Override
//    public List<Project> getAllProjects() {
//        return repository.findAll();
//    }
//
//    @Override
//    public Project update(String id, Project project) {
//        if (!repository.existsById(id)) {
//            throw new RuntimeException("Project not found. id:" + id);
//        }
//        project.setId(id);
//        Project updatedProject = repository.save(project);
//        List<ServiceAccount> serviceAccounts = serviceAccountRepository.findAllByProjectId(id);
//        serviceAccounts.forEach(serviceAccount -> { serviceAccount.setProject(updatedProject); });
//        serviceAccountRepository.saveAll(serviceAccounts);
//        return updatedProject;
//    }
//
//    @Override
//    public void delete(String id) {
//        repository.deleteById(id);
//    }
//}
