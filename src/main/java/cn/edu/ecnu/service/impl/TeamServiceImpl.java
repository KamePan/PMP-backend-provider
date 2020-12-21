package cn.edu.ecnu.service.impl;

import cn.edu.ecnu.dao.TeamMapper;
import cn.edu.ecnu.dao.TeamStudentMapper;
import cn.edu.ecnu.domain.Team;
import cn.edu.ecnu.domain.TeamStudent;
import cn.edu.ecnu.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "Team", keyGenerator = "keyGenerator")
@Service
public class TeamServiceImpl implements ITeamService {

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private TeamStudentMapper teamStudentMapper;

    /*@Autowired
    private RedisTemplate<String, Object> redisTemplate;*/

    @Cacheable(unless="#result == null")
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

    public void insertTeam(Team team, String uid) {
        TeamStudent teamStudent = new TeamStudent(team.getTeamid(), uid);
        teamStudentMapper.insert(teamStudent);
        teamMapper.insert(team);
    }

    public void inviteMember(TeamStudent teamStudent) {
        teamStudentMapper.insert(teamStudent);
    }
}
