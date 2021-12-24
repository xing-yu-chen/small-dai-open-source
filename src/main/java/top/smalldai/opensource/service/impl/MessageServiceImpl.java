package top.smalldai.opensource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.smalldai.opensource.entity.Message;
import top.smalldai.opensource.mapper.MessageMapper;
import top.smalldai.opensource.service.MessageService;

/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: 留言表ServiceImpl
* @Data:Created in 2021/12/21 9:58 下午
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper,Message> implements MessageService {
}
