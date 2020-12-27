package cn.edu.ecnu.service.impl;

import cn.edu.ecnu.dao.StudentMapper;
import cn.edu.ecnu.dao.TeamMapper;
import cn.edu.ecnu.dao.TeamStudentMapper;
import cn.edu.ecnu.dao.UserMapper;
import cn.edu.ecnu.domain.Student;
import cn.edu.ecnu.domain.Team;
import cn.edu.ecnu.domain.TeamStudent;
import cn.edu.ecnu.domain.TeamStudentExample;
import cn.edu.ecnu.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@CacheConfig(cacheNames = "Team", keyGenerator = "keyGenerator")
@Service
public class TeamServiceImpl implements ITeamService {

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeamStudentMapper teamStudentMapper;

    @Autowired
    private UserMapper userMapper;

    /*@Autowired
    private RedisTemplate<String, Object> redisTemplate;*/

    //@Cacheable(unless="#result == null")
    public Team findTeamById(String tid) {
        Team team = null;

        /*if (redisTemplate.hasKey(tid)) {
            team = (Team) redisTemplate.opsForValue().get(tid);
        } else {
        team = teamMapper.selectByPrimaryKey(tid);
        redisTemplate.opsForValue().set(tid, team, 1, TimeUnit.MINUTES); //设置 1 分钟过期时间
        }*/
        team = teamMapper.selectByPrimaryKey(tid);

        return team;
    }

    public Team insertTeam(Team team, String uid) {
        TeamStudent teamStudent = new TeamStudent(team.getTeamid(), uid);
        teamMapper.insert(team);
        teamStudentMapper.insert(teamStudent);
        return teamMapper.selectByPrimaryKey(team.getTeamid());
    }

    public void inviteMember(TeamStudent teamStudent) {
        teamStudentMapper.insert(teamStudent);
    }

    @Override
    public List<Team> findTeamsBySid(String sid) {
        Student student = studentMapper.selectByPrimaryKey(sid);
        List<Team> teams= new ArrayList<>();
        for (Team team : student.getTeams()) {
            teams.add(teamMapper.selectByPrimaryKey(team.getTeamid()));
        }
        return teams;
    }

    @Override
    public void deleteStudentFromTeam(TeamStudent teamStudent) {
        TeamStudentExample example = new TeamStudentExample();
        TeamStudentExample.Criteria criteria = example.createCriteria();
        criteria.andTeamidEqualTo(teamStudent.getTeamid()).andSidEqualTo(teamStudent.getSid());
        teamStudentMapper.deleteByExample(example);
    }

    public Team updateTeamName(String teamid, String teamname) {
        Team team = teamMapper.selectByPrimaryKey(teamid);
        team.setTeamname(teamname);
        teamMapper.updateByPrimaryKey(team);
        return team;
    }


}
