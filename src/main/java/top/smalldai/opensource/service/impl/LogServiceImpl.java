package top.smalldai.opensource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.smalldai.opensource.entity.Log;
import top.smalldai.opensource.mapper.LogMapper;
import top.smalldai.opensource.service.LogService;

/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: ServiceImpl
* @Data:Created in 2021/12/21 9:58 下午
*/
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper,Log> implements LogService {
}
