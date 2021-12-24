package top.smalldai.opensource.util.generator.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xing-yu-chen
 * @Project: open-source
 * @Description: 列实体
 * @Data:Created in 2021/12/19 11:19 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColumnDao {
    private String columnName;//列名
    private String dealingColumnName;//列名称(处理后的列名称)
    private String columnType; //列类型
    private String columnDbType;//列类型路径
    private String columnComment; //列备注
    private boolean columnKey; //是否为主键
}
