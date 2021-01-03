package cn.edu.ecnu.service;

import cn.edu.ecnu.domain.Judge;
import cn.edu.ecnu.domain.User;

import java.util.List;

public interface IUserService {

    void insertUserForTeacher(User user);

    User registerUser(User user);

    List<User> getAllUsers();

    User findUserByUsername(String username);

    void modifyPassword(User user);
}
