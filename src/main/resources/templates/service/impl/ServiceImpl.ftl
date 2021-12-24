package ${basePackage};

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import ${entityPackage}.${tableObj.dealingTableName};
import ${mapperPackage}.${tableObj.dealingTableName}Mapper;
import ${servicePackage}.${tableObj.dealingTableName}Service;

/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: ${tableObj.comment}ServiceImpl
* @Data:Created in 2021/12/21 9:58 下午
*/
@Service
public class ${tableObj.dealingTableName}ServiceImpl extends ServiceImpl<${tableObj.dealingTableName}Mapper,${tableObj.dealingTableName}> implements ${tableObj.dealingTableName}Service {
}
