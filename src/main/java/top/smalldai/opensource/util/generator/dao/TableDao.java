package top.smalldai.opensource.util.generator.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: xing-yu-chen
 * @Project: open-source
 * @Description: 表实体
 * @Data:Created in 2021/12/19 11:18 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableDao {
    private String tableName;//表名称
    private String dealingTableName; //处理后的表名称
    private String comment; //介绍
    private String key; //主键
    private List<ColumnDao> columns;//列集合
}
