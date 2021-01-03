package cn.edu.ecnu.service;

import cn.edu.ecnu.domain.Project;
import cn.edu.ecnu.domain.Teacher;

import java.util.List;

public interface IProjectService {

    Project insertProject(Project project);

    Project findProjectById(String pid);

    List<Project> findProjectsBySid(String sid);

    void updateProject(Project project);

    List<Project> findProjectsWithStageEqualsTwo();

    List<Project> findProjectsNeedsType();

    List<Project> fuzzyQueryForProjects(Project project);

    List<Project> findAllProjects();

}
