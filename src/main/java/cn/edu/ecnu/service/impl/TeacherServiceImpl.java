package cn.edu.ecnu.service.impl;

import cn.edu.ecnu.dao.ProjectMapper;
import cn.edu.ecnu.dao.TeacherMapper;
import cn.edu.ecnu.dao.TeamMapper;
import cn.edu.ecnu.domain.Project;
import cn.edu.ecnu.domain.Teacher;
import cn.edu.ecnu.domain.Team;
import cn.edu.ecnu.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "Teacher")
@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private ProjectMapper projectMapper;

    //@Cacheable(keyGenerator = "keyGenerator")
    public Teacher findTeacherById(String tid) {
        Teacher teacher = teacherMapper.selectByPrimaryKey(tid);
        List<Project> projectsToInstruct = teacher.getProjectsToInstruct();
        List<Project> projectsToJudge = teacher.getProjectsToJudge();
        for (int i = 0; i < projectsToInstruct.size(); i++) {
            projectsToInstruct.set(i, projectMapper.selectByPrimaryKey(projectsToInstruct.get(i).getPid()));
        }
        for (int i = 0; i < projectsToJudge.size(); i++) {
            projectsToJudge.set(i, projectMapper.selectByPrimaryKey(projectsToJudge.get(i).getPid()));
        }
        return teacher;
    }

    //@CachePut(key = "targetClass + #p0.tid")
    public Teacher updateTeacherSelective(Teacher teacher) {
        teacherMapper.updateByPrimaryKeySelective(teacher);
        Teacher newTeacher = teacherMapper.selectByPrimaryKey(teacher.getTid());
        return newTeacher;
    }
}
