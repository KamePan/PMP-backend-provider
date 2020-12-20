package cn.edu.ecnu.service.impl;

import cn.edu.ecnu.dao.StudentMapper;
import cn.edu.ecnu.domain.Student;
import cn.edu.ecnu.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "Student", keyGenerator = "keyGenerator")
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Cacheable
    public Student findStudentById(String id) {
        Student student = studentMapper.selectByPrimaryKey(id);
        return student;
    }
}
