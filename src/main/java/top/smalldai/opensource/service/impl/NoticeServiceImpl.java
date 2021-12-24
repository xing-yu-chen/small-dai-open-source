package top.smalldai.opensource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.smalldai.opensource.entity.Notice;
import top.smalldai.opensource.mapper.NoticeMapper;
import top.smalldai.opensource.service.NoticeService;

/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: ServiceImpl
* @Data:Created in 2021/12/21 9:58 下午
*/
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper,Notice> implements NoticeService {
}
