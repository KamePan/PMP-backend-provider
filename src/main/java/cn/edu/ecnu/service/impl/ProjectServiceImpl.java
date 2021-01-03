package cn.edu.ecnu.service.impl;

import cn.edu.ecnu.dao.ProjectMapper;
import cn.edu.ecnu.dao.StudentMapper;
import cn.edu.ecnu.dao.TeacherMapper;
import cn.edu.ecnu.dao.TeamMapper;
import cn.edu.ecnu.domain.*;
import cn.edu.ecnu.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@CacheConfig(cacheNames = "Project", keyGenerator = "keyGenerator")
@Service
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private ProjectMapper projectMapper;

    //@Cacheable
    public Project findProjectById(String pid) {
        Project project = projectMapper.selectByPrimaryKey(pid);
        return project;
    }

    public List<Project> fuzzyQueryForProjects(Project project) {
        /*ProjectExample example = new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        if (project.getPid() != null) {
            criteria.andPidEqualTo(project.getPid());
        }
        if (project.getProjectname() != null) {
            criteria.andProjectnameLike(project.getProjectname());
        }
        if (project.getType() != null) {
            criteria.andTypeEqualTo(project.getType());
        }
        if (project.getStage() != null) {
            criteria.andStageEqualTo(project.getStage());
        }
        System.out.println(example.toString());*/
        List<Project> projects = projectMapper.fuzzyQueryForProjects(project);
        System.out.println(projects);
        return projects;
    }

    @Override
    public List<Project> findAllProjects() {
        ProjectExample example = new ProjectExample();
        List<Project> projects = projectMapper.selectByExample(example);
        return projects;
    }

    /*效率很低的做法*/
    @Override
    public List<Project> findProjectsBySid(String sid) {
        Student student = studentMapper.selectByPrimaryKey(sid);
        List<Team> teams = student.getTeams();
        List<Project> projects = new ArrayList<>();
        for (Team team : teams) {
            if (team.getTeamid() != null) {
                team = teamMapper.selectByPrimaryKey(team.getTeamid());
                List<Project> projectsForOneTeam = team.getProjects();
                for (Project project : projectsForOneTeam) {
                    if (project.getPid() != null) {
                        Project project1 = projectMapper.selectByPrimaryKey(project.getPid());
                        project1.setTeam(teamMapper.selectByPrimaryKey(project1.getTeamid()));
                        /*if (project1.getAttachments().size() == 1 && project1.getAttachments().get(0).getAid() == null) {
                            project1.setAttachments(null);
                        }*/
                        projects.add(project1);
                    }
                }
            }
        }
        return projects;
    }

    @Override
    public void updateProject(Project project) {
        projectMapper.updateByPrimaryKeySelective(project);
    }

    public Project insertProject(Project project) {
        TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(project.getAdvisor().getUsername());
        List<Teacher> teachers = teacherMapper.selectByExample(example);
        if (teachers.size() == 0) {
            return null;
        }
        project.setTeam(teamMapper.selectByPrimaryKey(project.getTeamid()));
        project.setAdvisorid(teachers.get(0).getTid());
        projectMapper.insertSelective(project);
        return project;
    }

    public List<Project> findProjectsWithStageEqualsTwo() {
        List<Project> projects = projectMapper.selectWithStageEqualsTwo();
        return projects;
    }

    public List<Project> findProjectsNeedsType() {
        List<Project> projects = projectMapper.selectWithNeedsType();
        return projects;
    }
}
