package cn.edu.ecnu.service;

import cn.edu.ecnu.domain.Team;
import cn.edu.ecnu.domain.TeamStudent;

import java.util.List;

public interface ITeamService {

    Team findTeamById(String tid);

    Team insertTeam(Team team, String uid);

    void inviteMember(TeamStudent teamStudent);

    List<Team> findTeamsBySid(String sid);

    void deleteStudentFromTeam(TeamStudent teamStudent);

    Team updateTeamName(String teamid, String teamname);

    void deleteTeamByTeamid(String teamid);

}
