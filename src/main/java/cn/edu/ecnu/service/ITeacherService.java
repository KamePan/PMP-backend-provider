package cn.edu.ecnu.service;

import cn.edu.ecnu.domain.Teacher;

import java.util.List;

public interface ITeacherService {

    List<Teacher> findAllTeachers();

    public Teacher findTeacherById(String tid);

    public Teacher updateTeacherSelective(Teacher teacher);

    List<Teacher> fuzzyQueryForTeachers(Teacher teacher);

    Teacher findTeacherByUsername(String username);

}
