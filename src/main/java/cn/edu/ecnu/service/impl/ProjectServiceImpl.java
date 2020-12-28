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
        //project.setTeam(teamMapper.selectByPrimaryKey(project.getTeamid()));
        return project;
    }

    /*效率很低的做法*/
    @Override
    public List<Project> findProjectsBySid(String sid) {
        Student student = studentMapper.selectByPrimaryKey(sid);
        List<Team> teams = student.getTeams();
        List<Project> projects = new ArrayList<>();
        for (Team team : teams) {
            if (team.getTeamid() != null) {
                Team team1 = teamMapper.selectByPrimaryKey(team.getTeamid());
                List<Project> projectsForOneTeam = team1.getProjects();
                for (Project project : projectsForOneTeam) {
                    if (project.getPid() != null) {
                        Project project1 = projectMapper.selectByPrimaryKey(project.getPid());
                        if (project1.getAttachments().size() == 1 && project1.getAttachments().get(0).getAid() == null) {
                            project1.setAttachments(null);
                        }
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
}
