package cn.edu.ecnu.service.impl;

import cn.edu.ecnu.dao.ProjectMapper;
import cn.edu.ecnu.dao.TeacherMapper;
import cn.edu.ecnu.dao.TeamMapper;
import cn.edu.ecnu.domain.*;
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

    @Override
    public List<Teacher> findAllTeachers() {
        TeacherExample example = new TeacherExample();
        return teacherMapper.selectByExample(example);
    }

    //@Cacheable(keyGenerator = "keyGenerator")
    public Teacher findTeacherById(String tid) {
        Teacher teacher = teacherMapper.selectByPrimaryKey(tid);
        List<Message> messages = teacher.getMessages();
        for (int a = messages.size() - 1; a >= 0; a--) {
            if (messages.get(a).getMid() == null) {
                messages.remove(messages.get(a));
            }
        }
        teacher.setMessages(messages);
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

    @Override
    public List<Teacher> fuzzyQueryForTeachers(Teacher teacher) {
        /*TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria = example.createCriteria();
        if (teacher.getTid() != null) {
            criteria.andTidEqualTo(teacher.getTid());
        }
        if (teacher.getUsername() != null) {
            criteria.andUsernameLike(teacher.getUsername());
        }
        if (teacher.getDepartment() != null) {
            criteria.andDepartmentLike(teacher.getDepartment());
        }*/
        return teacherMapper.fuzzyQueryForTeachers(teacher);
    }

    @Override
    public Teacher findTeacherByUsername(String username) {
        TeacherExample example = new TeacherExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Teacher> teachers = teacherMapper.selectByExample(example);
        if (teachers.size() == 0) {
            return null;
        } else {
            return teachers.get(0);
        }
    }
}
