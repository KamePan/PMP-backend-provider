package cn.edu.ecnu.service.impl;

import cn.edu.ecnu.dao.TeacherMapper;
import cn.edu.ecnu.domain.Teacher;
import cn.edu.ecnu.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "Teacher")
@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Cacheable(keyGenerator = "keyGenerator")
    public Teacher findTeacherById(String tid) {
        Teacher teacher = teacherMapper.selectByPrimaryKey(tid);;
        return teacher;
    }

    @CachePut(key = "targetClass + #p0.tid")
    public Teacher updateTeacherSelective(Teacher teacher) {
        teacherMapper.updateByPrimaryKeySelective(teacher);
        Teacher newTeacher = teacherMapper.selectByPrimaryKey(teacher.getTid());
        return newTeacher;
    }
}
