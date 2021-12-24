package top.smalldai.opensource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.smalldai.opensource.entity.User;

/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: 用户表Mapper
* @Data:Created in 2021/12/21 9:20 下午
*/
@Mapper
public interface UserMapper extends BaseMapper<User>{
}
