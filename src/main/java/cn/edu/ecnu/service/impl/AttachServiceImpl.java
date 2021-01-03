package cn.edu.ecnu.service.impl;

import cn.edu.ecnu.dao.AttachmentMapper;
import cn.edu.ecnu.domain.Attachment;
import cn.edu.ecnu.service.IAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachServiceImpl implements IAttachService {

    @Autowired
    private AttachmentMapper attachmentMapper;

    /*将 attachment 对象添加到数据库中*/
    public void insertAttachment(Attachment attachment) {
        attachmentMapper.insert(attachment);
    }

    @Override
    public void deleteAttachmentByAid(String aid) {
        attachmentMapper.deleteByPrimaryKey(aid);
    }

    @Override
    public Attachment findAttachmentByAid(String aid) {
        Attachment attachment = attachmentMapper.selectByPrimaryKey(aid);
        return attachment;
    }
}
