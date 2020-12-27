package cn.edu.ecnu.service.impl;

import cn.edu.ecnu.dao.AdviceMapper;
import cn.edu.ecnu.domain.Advice;
import cn.edu.ecnu.service.IAdviceService;
import com.alibaba.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdviceServiceImpl implements IAdviceService {

    @Autowired
    private AdviceMapper adviceMapper;

    private Logger logger = LoggerFactory.getLogger(AdviceServiceImpl.class);

    public void insertAdvice(Advice advice) {
        adviceMapper.insert(advice);
    }

}
