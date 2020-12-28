package cn.edu.ecnu.service.impl;

import cn.edu.ecnu.dao.StudentMapper;
import cn.edu.ecnu.domain.Student;
import cn.edu.ecnu.domain.StudentExample;
import cn.edu.ecnu.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "Student", keyGenerator = "keyGenerator")
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    //@Cacheable(unless="#result == null")
    public Student findStudentById(String id) {
        Student student = studentMapper.selectByPrimaryKey(id);
        return student;
    }

    @Override
    public Student findUserByUsername(String username) {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Student> students = studentMapper.selectByExample(example);
        if (students.size() == 0) {
            return null;
        }
        return students.get(0);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateByPrimaryKeySelective(student);
    }
}
