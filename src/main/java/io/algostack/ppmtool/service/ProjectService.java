package io.algostack.ppmtool.service;

import io.algostack.ppmtool.domain.Project;
import io.algostack.ppmtool.exception.ProjectIdException;
import io.algostack.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository  projectRepository;

    public Project saveOrUpdateProject(Project project)
    {
        try {

            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ProjectIdException("Project Id "+project.getProjectIdentifier().toUpperCase()+" already exists");
        }
    }

    public Project findProjectByIdentifier (String projectId) {

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if (project == null)
        {
            throw new ProjectIdException("Project Id "+projectId+" does not exists");

        }
        return project;
    }

    public Iterable<Project> findAllProjects () {
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project == null)
        {
            throw  new ProjectIdException("Cannot Project with ID "+projectId+". This project doesn't exist ");
        }
        projectRepository.delete(project);
    }
}
