package cn.edu.ecnu.service.impl;

import cn.edu.ecnu.dao.StudentMapper;
import cn.edu.ecnu.dao.TeacherMapper;
import cn.edu.ecnu.dao.UserMapper;
import cn.edu.ecnu.domain.*;
import cn.edu.ecnu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "User", keyGenerator = "keyGenerator")
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Cacheable
    public List<User> getAllUsers() {
        List<User> users = null;
        UserExample example = new UserExample();
        users = userMapper.selectByExample(example);
        return users;
    }


    public User registerUser(User user) {
        if (findUserByUsername(user.getUsername()) != null) {
            throw new RuntimeException("用户名已被注册");
        }
        Student student = new Student();
        student.setSid(user.getUid());
        student.setUsername(user.getUsername());
        studentMapper.insertSelective(student);
        userMapper.insertSelective(user);
        return user;
    }

    public void insertUserForTeacher(User user) {
        if (findUserByUsername(user.getUsername()) != null) {
            throw new RuntimeException("用户名已被注册");
        }
        Teacher teacher = new Teacher();
        teacher.setTid(user.getUid());
        teacher.setUsername(user.getUsername());
        teacherMapper.insertSelective(teacher);
        userMapper.insertSelective(user);
    }


    public User findUserByUsername(String username) {
        UserExample example =  new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    public void modifyPassword(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }


}
