//package br.com.project.sistema.gerenciador.conta.application.controller;
//
//import br.com.project.sistema.gerenciador.conta.domain.model.Project;
//import br.com.project.sistema.gerenciador.conta.domain.service.ProjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/project")
//public class ProjectController {
//
//    @Autowired
//    private ProjectService service;
//
//    @GetMapping
//    public ResponseEntity<List<Project>> getAllProjects() {
//        List<Project> projects = service.getAllProjects();
//        return ResponseEntity.ok(projects);
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<Project> getProject(@PathVariable String id) {
//        Project project = service.getProject(id);
//        return ResponseEntity.ok(project);
//    }
//
//    @PostMapping
//    public ResponseEntity<Project> createProject(@RequestBody Project project) {
//        Project createdProject = service.create(project);
//        return ResponseEntity.ok(createdProject);
//    }
//
//    @PutMapping ("{id}")
//    public ResponseEntity<Project> updateProject(@PathVariable String id, @RequestBody Project project) {
//        Project updatedProject = service.update(id, project);
//        return ResponseEntity.ok(updatedProject);
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<?> deleteProject(@PathVariable String id) {
//        service.delete(id);
//        return ResponseEntity.ok().build();
//    }
//
//}
