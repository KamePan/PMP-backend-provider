package cn.edu.ecnu.service.impl;

import cn.edu.ecnu.dao.JudgeMapper;
import cn.edu.ecnu.dao.MessageMapper;
import cn.edu.ecnu.dao.ProjectMapper;
import cn.edu.ecnu.dao.TeamMapper;
import cn.edu.ecnu.domain.*;
import cn.edu.ecnu.service.IJudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class JudgeServiceImpl implements IJudgeService {

    @Autowired
    private JudgeMapper judgeMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private TeamMapper teamMapper;

    @Override
    public void assignJudgeForProject(Judge judge) {
        judgeMapper.insertSelective(judge);
        judgePass(judge, 4);
    }

    @Override
    public void updateJudgeForProject(Judge judge) {
        JudgeExample example = new JudgeExample();
        JudgeExample.Criteria criteria = example.createCriteria();
        criteria.andTidEqualTo(judge.getTid()).andPidEqualTo(judge.getPid());
        judgeMapper.updateByExampleSelective(judge, example);
        judgePass(judge, 3);
    }

    private void judgePass(Judge judge, int stage) {
        Project project = projectMapper.selectByPrimaryKey(judge.getPid());
        // 如果老师的数量为 3 且项目处于分配导师阶段，则说明导师分配结束，将 stage 置为 3;
        if (project.getStage() == 2 && project.getJudges().size() == 3) {
            project.setStage(3);
            projectMapper.updateByPrimaryKey(project);
            return;
        }
        int cnt = 0;
        int sumOfScore = 0;
        for (Judge projectJudge : project.getJudges()) {
            if (projectJudge.getStage() != null && projectJudge.getStage() == stage) {
                cnt ++;
                sumOfScore += projectJudge.getScore();
            }
        }
        //判断该 project 的 judges 中当前 stage 的老师数量是否为 3，设置平均分
        if (cnt == 3 && stage == 3) {
            project.setMidmark(sumOfScore / 3);
        } else if (cnt == 3 && stage == 4) {
            project.setFinalmark(sumOfScore / 3);
            project.setStage(5);

            String projectname = project.getProjectname();
            List<Student> students = teamMapper.selectByPrimaryKey(project.getTeam().getTeamid()).getStudents();
            for (Student student : students) {
                Message message = new Message();
                message.setMid("M" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
                message.setMessagetime(new Date());
                message.setContent("项目 " + projectname + " 终期结题评审结束");
                message.setUid(student.getSid());
                messageMapper.insert(message);
            }
        }
        projectMapper.updateByPrimaryKey(project);
    }


}
