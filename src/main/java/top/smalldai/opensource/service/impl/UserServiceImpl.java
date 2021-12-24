package top.smalldai.opensource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.smalldai.opensource.entity.User;
import top.smalldai.opensource.mapper.UserMapper;
import top.smalldai.opensource.service.UserService;

/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: 用户表ServiceImpl
* @Data:Created in 2021/12/21 9:58 下午
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
}
