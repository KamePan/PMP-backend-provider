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
        // 本端是否为提供端，这里会返回true
        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        // 获取调用方IP地址
        String clientIp = RpcContext.getContext().getRemoteHost();
        // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        String url = RpcContext.getContext().getUrl().toFullString();

        logger.info("{} {} {}", isProviderSide, clientIp, url);
        adviceMapper.insert(advice);
    }

}
