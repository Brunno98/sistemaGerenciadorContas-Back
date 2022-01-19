package br.com.project.sistema.gerenciador.conta.domain.service;

import br.com.project.sistema.gerenciador.conta.domain.model.Project;

import java.util.List;

public interface ProjectService {
    Project create(Project project);
    Project getProject(String id);
    List<Project> getAllProjects();
    Project update(String id, Project project);
    void delete(String id);
}
