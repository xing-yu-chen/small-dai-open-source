package ${basePackage};

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import ${entityPackage}.${tableObj.dealingTableName};

/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: ${tableObj.comment}Mapper
* @Data:Created in 2021/12/21 9:20 下午
*/
@Mapper
public interface ${tableObj.dealingTableName}Mapper extends BaseMapper<${tableObj.dealingTableName}>{
}
