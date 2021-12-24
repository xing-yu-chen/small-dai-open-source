package top.smalldai.opensource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.smalldai.opensource.entity.Role;
import top.smalldai.opensource.mapper.RoleMapper;
import top.smalldai.opensource.service.RoleService;

/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: 角色表ServiceImpl
* @Data:Created in 2021/12/21 9:58 下午
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService {
}
