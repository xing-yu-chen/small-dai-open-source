package top.smalldai.opensource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.smalldai.opensource.entity.Permission;
import top.smalldai.opensource.mapper.PermissionMapper;
import top.smalldai.opensource.service.PermissionService;

/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: 权限菜单表ServiceImpl
* @Data:Created in 2021/12/21 9:58 下午
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper,Permission> implements PermissionService {
}
