package cn.edu.ecnu.service.impl;

import cn.edu.ecnu.dao.MessageMapper;
import cn.edu.ecnu.domain.Message;
import cn.edu.ecnu.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private MessageMapper messageMapper;

    public void insertMessage(Message message) {
        messageMapper.insert(message);
    }
}
